package io.pranludi.server.exception;

public class MemberNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -8790211652911971729L;

  public MemberNotFoundException() {
    super();
  }

  public MemberNotFoundException(String body) {
    super(body);
  }

}
