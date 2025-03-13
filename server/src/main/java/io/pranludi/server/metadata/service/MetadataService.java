package io.pranludi.server.metadata.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class MetadataService {

  public LocalDateTime currentDataTime() {
    return LocalDateTime.now();
  }

  public int currentMemberVersion() {
    return 0;
  }

}
