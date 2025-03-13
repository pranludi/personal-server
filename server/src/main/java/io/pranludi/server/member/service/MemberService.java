package io.pranludi.server.member.service;

import io.pranludi.server.domain.member.Member;
import io.pranludi.server.exception.MemberNotFoundException;
import io.pranludi.server.member.repository.MemberRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  final MigrationService migrationService;
  final MemberRepository memberRepository;

  public MemberService(MigrationService migrationService, MemberRepository memberRepository) {
    this.migrationService = migrationService;
    this.memberRepository = memberRepository;
  }

  public Optional<Member> getMember(String memberId) {
    return memberRepository.findById(memberId);
  }

  public Member findMember(String memberId) throws MemberNotFoundException {
    Optional<Member> optMember = getMember(memberId);
    if (optMember.isEmpty()) {
      throw new MemberNotFoundException("member not found");
    }
    return migrationService.migration(optMember.get());
  }

  public void save(String memberId, Member member) {
    memberRepository.save(memberId, member);
  }

}
