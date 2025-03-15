package io.pranludi.server.cheat;

import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.member.Reward;
import io.pranludi.server.domain.metadata.EnvironmentData;
import io.pranludi.server.logic.RewardLogic;
import io.pranludi.server.member.MemberService;
import jakarta.transaction.Transactional;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class CheatService {

  final MemberService memberService;

  public CheatService(MemberService memberService) {
    this.memberService = memberService;
  }

  @Transactional
  public Function<EnvironmentData, Reward> cheatReward(ItemDataId itemDataId, long amount) {
    return (EnvironmentData env) -> {
      Member member = memberService.findMember().apply(env);
      Reward reward = RewardLogic.receive(member, false, itemDataId, amount).apply(env);
      memberService.save(member).accept(env);
      return reward;
    };
  }

}
