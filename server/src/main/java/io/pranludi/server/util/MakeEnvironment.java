package io.pranludi.server.util;

import io.pranludi.server.config.interceptor.InterceptorConstant;
import io.pranludi.server.domain.entity.MemberId;
import io.pranludi.server.domain.metadata.EnvironmentData;
import io.pranludi.server.metadata.MetadataService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class MakeEnvironment {

  final MetadataService metadataService;

  public MakeEnvironment(MetadataService metadataService) {
    this.metadataService = metadataService;
  }

  public EnvironmentData make() {
    MemberId memberId = InterceptorConstant.CTX_MEMBER_ID.get();

    EnvironmentData environmentData = new EnvironmentData(memberId, LocalDateTime.now(), metadataService.get());

    return environmentData;
  }
}
