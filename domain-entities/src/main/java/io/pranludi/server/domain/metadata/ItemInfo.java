package io.pranludi.server.domain.metadata;

import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.entity.ItemType;

public record ItemInfo(
  ItemDataId itemDataId,
  String itemName,
  ItemType itemType
) {

}
