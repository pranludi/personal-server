package io.pranludi.server.logic;

import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.metadata.ItemInfo;
import io.pranludi.server.domain.metadata.Metadata;
import io.pranludi.server.exception.ValidationError;
import java.util.function.Function;

public class MetadataLogic {

  public static Function<Metadata, ItemInfo> inquireItemInfo(ItemDataId dataId) {
    return (Metadata metadata) -> {
      for (ItemInfo itemInfo : metadata.itemInfos()) {
        if (itemInfo.itemDataId().equals(dataId)) {
          return itemInfo;
        }
      }
      throw new ValidationError("ItemInfo not found: " + dataId);
    };
  }

}
