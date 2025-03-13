package io.pranludi.server.exception;

public class CommonException extends RuntimeException {

  private static final long serialVersionUID = -8790211652911971729L;

  public CommonException(String body) {
    super(body);
  }
}
