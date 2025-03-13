package io.pranludi.server.config;

import io.pranludi.server.domain.metadata.Metadata;
import io.pranludi.server.metadata.MetadataService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class StartupPreparations implements InitializingBean {

  final MetadataService metadataService;

  public StartupPreparations(MetadataService metadataService) {
    this.metadataService = metadataService;
  }

  @Override
  public void afterPropertiesSet() {
    System.out.println("Server Start - data loading");

    Metadata metadata = new Metadata(0);

    metadataService.update(metadata);
  }

}
