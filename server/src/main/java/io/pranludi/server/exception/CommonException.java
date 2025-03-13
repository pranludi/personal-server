package io.pranludi.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "common exception")
public class CommonException extends RuntimeException {

  private static final long serialVersionUID = -8790211652911971729L;

  public CommonException(String body) {
    super(body);
  }
}
