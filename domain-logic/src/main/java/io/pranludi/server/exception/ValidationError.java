package io.pranludi.server.exception;

import java.util.Arrays;

public class ValidationError extends RuntimeException {

  private String message;
  private int code;
  private Object[] arguments;

  public ValidationError(String message, int code) {
    super(message);
    this.message = message;
    this.code = code;
  }

  public ValidationError(String message, Object... arguments) {
    this.message = message;
    this.arguments = arguments;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  @Override
  public String toString() {
    if (message.indexOf("\"") > 0) {
      message = message.replace("\"", "'");
    }
    if (arguments != null) {
      return "ServerException," + message + "," + code + "," + Arrays.toString(arguments);
    }
    return "ServerException," + message + "," + code;
  }

}
