package io.pranludi.server.exception;

public class MemberNotFoundException extends ServerError {

  public MemberNotFoundException(String body) {
    super(body);
  }

}
