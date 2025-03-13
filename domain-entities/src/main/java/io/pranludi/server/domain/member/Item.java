package io.pranludi.server.domain.member;

import io.soabase.recordbuilder.core.RecordBuilder;
import java.time.LocalDateTime;

@RecordBuilder
public record Item(
  int dataId,
  long free,
  long paid,
  LocalDateTime useAt, // 아이템 사용 시간
  LocalDateTime untilAt // 무제한 아이템 사용 가능 시간
) {

}
