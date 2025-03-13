package io.pranludi.server.domain.member;

public enum MemberStatus {
  NONE(0),
  NORMAL(1);

  private int value;

  MemberStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
