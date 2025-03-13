package io.pranludi.server.member.service;

import static io.pranludi.server.logic.MemberLogic.initialMember;

import io.pranludi.server.domain.member.Member;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

  final MemberService memberService;

  public LoginService(MemberService memberService) {
    this.memberService = memberService;
  }

  @Transactional
  public Member login(String memberId, LocalDateTime currentTime) {
    Optional<Member> optMember = memberService.getMember(memberId);
    if (optMember.isEmpty()) {
      memberService.save(memberId, initialMember(memberId, currentTime));
    }

    return memberService.findMember(memberId);
  }

}
