package io.pranludi.server.member;

import io.pranludi.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<User, String> {

}
