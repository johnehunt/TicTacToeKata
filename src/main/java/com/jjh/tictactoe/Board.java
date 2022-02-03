package com.jjh.tictactoe;

public class Board {

  public static final String X = "X";
  public static final String O = "O";

  private final String[][] cells = new String[3][3];

  private String lastPlayer = "";

  public boolean isEmpty() {
    for (String[] row : cells) {
      for (String counter : row) {
        if (counter != null) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isCellEmpty(int row, int col) {
    String counter = cells[row][col];
    return counter == null;
  }

  public void addCounter(String counter, int row, int col) {
    if (counter.equals(lastPlayer)) {
      throw new OutOfSequenceException("Last player same as current player = %s".formatted(counter));
    }
    if (!isCellEmpty(row, col)) {
      throw new CellNotAvailableException("Cell(%d,%d) - already filled".formatted(row, col));
    }
    lastPlayer = counter;
    cells[row][col] = counter;
  }

  public boolean isFull() {
    for (String[] row : cells) {
      for (String counter : row) {
        if (counter == null) {
          return false;
        }
      }
    }
    return true;
  }

  public void printBoard() {
    for (String[] cell : cells) {
      System.out.println("-------");
      for (String s : cell) {
        System.out.printf("|%s", s);
      }
      System.out.println(("|"));
    }
    System.out.println("-------");
  }
}
