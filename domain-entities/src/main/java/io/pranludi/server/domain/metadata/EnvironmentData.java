package io.pranludi.server.domain.metadata;

import io.pranludi.server.domain.entity.MemberId;
import java.time.LocalDateTime;

public record EnvironmentData(
  MemberId memberId,
  LocalDateTime currentDateTime,
  Metadata metadata
) {

}
