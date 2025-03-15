package io.pranludi.server.domain.member;

import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.entity.MemberName;
import io.soabase.recordbuilder.core.RecordBuilder;
import java.time.LocalDateTime;
import java.util.Map;

@RecordBuilder
public record Member(
  int version,
  MemberStatus memberStatus, // 사용자 상태. -9 탈퇴 / 1 일반 / 2 복귀 유저(친구 초대 이벤트)
  MemberName memberName, // 사용자 닉네임
  LocalDateTime createdAt,
  LocalDateTime loginAt,
  Map<ItemDataId, Currency> currencies, // 사용자 보유 재화 목록
  Map<ItemDataId, Item> items // 사용자 보유 아이템 목록
) implements MemberBuilder.With {

}
