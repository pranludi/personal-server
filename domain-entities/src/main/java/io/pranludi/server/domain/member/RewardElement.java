package io.pranludi.server.domain.member;

public record RewardElement(
  RewardCurrency currency,
  RewardItem item,
  RewardProfile profile
) {

}
