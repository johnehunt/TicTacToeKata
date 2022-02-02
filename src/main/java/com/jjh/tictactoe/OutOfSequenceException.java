package com.jjh.tictactoe;

public class OutOfSequenceException extends RuntimeException {
  public OutOfSequenceException(String message) {
    super(message);
  }

  public OutOfSequenceException(String message, Throwable cause) {
    super(message, cause);
  }
}
