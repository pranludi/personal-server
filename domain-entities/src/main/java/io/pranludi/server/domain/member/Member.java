package io.pranludi.server.domain.member;

import io.soabase.recordbuilder.core.RecordBuilder;
import java.time.LocalDateTime;
import java.util.List;

@RecordBuilder
public record Member(
  int version,
  MemberStatus memberStatus, // 사용자 상태. -9 탈퇴 / 1 일반 / 2 복귀 유저(친구 초대 이벤트)
  MemberName memberName, // 사용자 닉네임
  LocalDateTime createdAt,
  LocalDateTime loginAt,
  List<Currency> currencies, // 사용자 보유 재화 목록
  List<Item> items // 사용자 보유 아이템 목록
) implements MemberBuilder.With {

  public Member() {
    this(0, MemberStatus.NORMAL, new MemberName("", 0), LocalDateTime.now(), LocalDateTime.now(), List.of(), List.of());
  }

  public Member(int version, String memberName, LocalDateTime nowAt, List<Currency> currencies, List<Item> items) {
    this(version, MemberStatus.NORMAL, new MemberName(memberName, 0), nowAt, nowAt, currencies, items);
  }

}
