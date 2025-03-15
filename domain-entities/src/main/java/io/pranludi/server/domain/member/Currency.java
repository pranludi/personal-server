package io.pranludi.server.domain.member;

import io.soabase.recordbuilder.core.RecordBuilder;
import java.time.LocalDateTime;
import java.util.Objects;

@RecordBuilder
public record Currency(
  int dataId,
  long free,
  long paid,
  LocalDateTime useAt, // 재화 사용 시간
  LocalDateTime untilAt // 무제한 재화 사용 가능 시간
) implements CurrencyBuilder.With {

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Currency currency)) {
      return false;
    }
    return dataId == currency.dataId;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(dataId);
  }
}
