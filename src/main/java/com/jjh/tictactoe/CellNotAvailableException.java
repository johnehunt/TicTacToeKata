package com.jjh.tictactoe;

public class CellNotAvailableException extends RuntimeException {
  public CellNotAvailableException(String message) {
    super(message);
  }

  public CellNotAvailableException(String message, Throwable cause) {
    super(message, cause);
  }
}
