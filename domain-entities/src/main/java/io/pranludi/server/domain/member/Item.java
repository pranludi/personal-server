package io.pranludi.server.domain.member;

import java.time.LocalDateTime;

public record Item(
  int dataId,
  long free,
  long paid,
  LocalDateTime useAt, // 아이템 사용 시간
  LocalDateTime untilAt // 무제한 아이템 사용 가능 시간
) {

}
