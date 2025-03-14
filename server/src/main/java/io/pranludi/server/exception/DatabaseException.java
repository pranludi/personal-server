package io.pranludi.server.exception;

public class DatabaseException extends ServerError {

  public DatabaseException(String body) {
    super(body);
  }
}
