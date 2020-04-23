package com.application.cities.exceptions;

import java.text.MessageFormat;

public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(String message, Object... params) {
    super(MessageFormat.format(message, params));
  }
}
