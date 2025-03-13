package io.pranludi.server.domain.metadata;

import java.time.LocalDateTime;

public record EnvironmentData(
  String memberId,
  LocalDateTime currentDateTime,
  Metadata metadata
) {

}
