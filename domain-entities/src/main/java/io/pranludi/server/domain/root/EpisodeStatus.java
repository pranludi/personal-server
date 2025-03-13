package io.pranludi.server.domain.root;

public enum EpisodeStatus {
  // 신규 에피소드 미오픈.
  NONE(0),

  // 신규 에피소드 오픈.
  OPEN(1),

  // 메인 에피소드를 모두 클리어한 상태.
  ALL_CLEAR(2);

  EpisodeStatus(int value) {
    this.value = value;
  }

  private int value;

  public int value() {
    return value;
  }

}
