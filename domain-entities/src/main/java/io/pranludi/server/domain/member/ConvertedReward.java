package io.pranludi.server.domain.member;

import java.util.List;

public record ConvertedReward(
  int replacedOriginDataId,
  long replacedOriginQuantity,
  List<RewardElement> rewards
) {

}
