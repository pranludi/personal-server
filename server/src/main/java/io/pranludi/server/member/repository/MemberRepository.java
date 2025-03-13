package io.pranludi.server.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.member.entity.User;
import io.pranludi.server.member.entity.UserServerMapper;
import io.pranludi.server.protobuf.server.MemberStateDTO;
import jakarta.persistence.EntityManager;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

  private final EntityManager em;
  private final JPAQueryFactory queryFactory;

  public MemberRepository(EntityManager em) {
    this.em = em;
    this.queryFactory = new JPAQueryFactory(em);
  }

  public Optional<Member> findById(String memberId) {
    try {
      Optional<User> raw = Optional.ofNullable(em.find(User.class, memberId));
      if (raw.isPresent()) {
        return Optional.of(UserServerMapper.INSTANCE.protoToEntity(MemberStateDTO.parseFrom(raw.get().getMember())));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  public void save(String memberId, Member member) {
    try {
      MemberStateDTO memberState = UserServerMapper.INSTANCE.entityToProto(member);
      em.persist(new User(memberId, memberState.toByteArray()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
