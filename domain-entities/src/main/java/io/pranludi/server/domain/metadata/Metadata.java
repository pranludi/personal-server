package io.pranludi.server.domain.metadata;

import java.util.List;

public record Metadata(
  int currentMemberVersion,
  List<ItemInfo> itemInfos
) {

}
