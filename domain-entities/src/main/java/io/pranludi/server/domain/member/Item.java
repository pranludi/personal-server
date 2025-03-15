package io.pranludi.server.domain.member;

import io.soabase.recordbuilder.core.RecordBuilder;
import java.time.LocalDateTime;
import java.util.Objects;

@RecordBuilder
public record Item(
  int dataId,
  long free,
  long paid,
  LocalDateTime useAt, // 아이템 사용 시간
  LocalDateTime untilAt // 무제한 아이템 사용 가능 시간
) implements ItemBuilder.With {

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Item item)) {
      return false;
    }
    return dataId == item.dataId;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(dataId);
  }
}
