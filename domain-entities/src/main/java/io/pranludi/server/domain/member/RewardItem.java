package io.pranludi.server.domain.member;

public record RewardItem(
  int dataId, long amount
) {

  public static RewardItem empty() {
    return new RewardItem(0, 0);
  }

}
