package io.pranludi.server.domain.member;

import java.time.LocalDateTime;

public record Currency(
  int dataId,
  long free,
  long paid,
  LocalDateTime useAt, // 재화 사용 시간
  LocalDateTime untilAt // 무제한 재화 사용 가능 시간
) {

}
