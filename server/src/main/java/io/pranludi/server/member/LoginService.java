package io.pranludi.server.member;

import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.metadata.EnvironmentData;
import io.pranludi.server.logic.MemberLogic;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  final MemberService memberService;

  public LoginService(MemberService memberService) {
    this.memberService = memberService;
  }

  @Transactional
  public Member login(EnvironmentData env) {
    Optional<Member> optMember = memberService.getMember().apply(env);
    Member member = getMember(env, optMember);
    memberService.save(member).accept(env);

    return memberService.findMember().apply(env);
  }

  Member getMember(EnvironmentData env, Optional<Member> optMember) {
    if (optMember.isEmpty()) {
      return MemberLogic.initialMember().apply(env);
    } else {
      return optMember.get().withLoginAt(env.currentDateTime());
    }
  }

}
