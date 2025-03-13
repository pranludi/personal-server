package io.pranludi.server.metadata;

import io.pranludi.server.domain.metadata.Metadata;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Component;

@Component
public class MetadataService {

  private final AtomicReference<Metadata> refMetadata = new AtomicReference<>();

  public Metadata get() {
    return refMetadata.get();
  }

  public void update(Metadata metadata) {
    this.refMetadata.set(metadata);
  }

}
