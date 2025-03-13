package io.pranludi.server.exception;

public class InvalidDataException extends RuntimeException {

  private static final long serialVersionUID = -8790211652911971729L;

  public InvalidDataException(String body) {
    super(body);
  }

}
