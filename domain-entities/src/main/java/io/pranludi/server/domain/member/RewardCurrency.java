package io.pranludi.server.domain.member;

public record RewardCurrency(
  int dataId, long paid, long free
) {

  public static RewardCurrency empty() {
    return new RewardCurrency(0, 0, 0);
  }
}
