package io.pranludi.server.config;

import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.entity.ItemType;
import io.pranludi.server.domain.metadata.ItemInfo;
import io.pranludi.server.domain.metadata.Metadata;
import io.pranludi.server.metadata.MetadataService;
import java.util.ArrayList;
import java.util.List;
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

    List<ItemInfo> itemInfos = new ArrayList<>();
    itemInfos.add(new ItemInfo(new ItemDataId(101), "currency 101", ItemType.Currency1));
    itemInfos.add(new ItemInfo(new ItemDataId(102), "currency 102", ItemType.Currency2));
    itemInfos.add(new ItemInfo(new ItemDataId(201), "item 101", ItemType.Item1));
    itemInfos.add(new ItemInfo(new ItemDataId(202), "item 102", ItemType.Item2));

    Metadata metadata = new Metadata(0, itemInfos);

    metadataService.update(metadata);
  }

}
