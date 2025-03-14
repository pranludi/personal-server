package io.pranludi.server.member;

import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.metadata.EnvironmentData;
import io.pranludi.server.entity.ServerMapper;
import io.pranludi.server.entity.User;
import io.pranludi.server.exception.MemberNotFoundException;
import io.pranludi.server.logic.MigrationLogic;
import io.pranludi.server.protobuf.server.MemberStateDTO;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Function<EnvironmentData, Optional<Member>> getMember() {
    return (EnvironmentData env) -> {
      try {
        Optional<User> raw = memberRepository.findById(env.memberId().memberId());
        if (raw.isPresent()) {
          return Optional.of(ServerMapper.INSTANCE.protoToEntity(MemberStateDTO.parseFrom(raw.get().getMember())));
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return Optional.empty();
    };
  }

  public Function<EnvironmentData, Member> findMember() throws MemberNotFoundException {
    return (EnvironmentData env) -> {
      Optional<Member> optMember = getMember().apply(env);
      if (optMember.isEmpty()) {
        throw new MemberNotFoundException("member not found");
      }
      return MigrationLogic.migration(optMember.get(), env.metadata());
    };
  }

  public Consumer<EnvironmentData> save(Member member) {
    return (EnvironmentData env) -> {
      try {
        MemberStateDTO memberState = ServerMapper.INSTANCE.entityToProto(member);
        memberRepository.save(new User(env.memberId(), memberState.toByteArray()));
      } catch (Exception e) {
        e.printStackTrace();
      }
    };
  }

}
