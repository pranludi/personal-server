package io.pranludi.server.member;

import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.member.MemberName;
import io.pranludi.server.domain.metadata.EnvironmentData;
import io.pranludi.server.logic.MemberLogic;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  final MemberService memberService;

  public LoginService(MemberService memberService) {
    this.memberService = memberService;
  }

  @Transactional
  public Function<EnvironmentData, Member> login() {
    return (EnvironmentData env) -> {
      Optional<Member> optMember = memberService.getMember().apply(env);
      Member member = getMember(env, optMember);
      memberService.save(member).accept(env);

      return memberService.findMember().apply(env);
    };
  }

  Member getMember(EnvironmentData env, Optional<Member> optMember) {
    if (optMember.isEmpty()) {
      return MemberLogic.initialMember().apply(env);
    } else {
      return optMember.get().withLoginAt(env.currentDateTime());
    }
  }

  @Transactional
  public Function<EnvironmentData, MemberName> changeMemberName(String name) {
    return (EnvironmentData env) -> {
      Member member = memberService.findMember().apply(env);
      MemberName updateMemberName = new MemberName(name, member.memberName().editCount() + 1);
      memberService
        .save(member.withMemberName(updateMemberName))
        .accept(env);

      return updateMemberName;
    };
  }

}
