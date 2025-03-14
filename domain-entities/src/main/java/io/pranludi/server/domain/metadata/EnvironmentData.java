package io.pranludi.server.domain.metadata;

import io.pranludi.server.domain.member.MemberId;
import java.time.LocalDateTime;

public record EnvironmentData(
  MemberId memberId,
  LocalDateTime currentDateTime,
  Metadata metadata
) {

}
