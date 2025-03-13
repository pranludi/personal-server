package io.pranludi.server.domain.member;

public record MemberName(
  String name, // 사용자 닉네임
  int editCount // 닉네임 변경 횟수
) {

}
