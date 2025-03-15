package io.pranludi.server.domain.member;

public record RewardProfile(
  int dataId
) {

  public static RewardProfile empty() {
    return new RewardProfile(0);
  }
}
