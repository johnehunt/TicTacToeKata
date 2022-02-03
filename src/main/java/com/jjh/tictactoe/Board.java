package com.jjh.tictactoe;

public class Board {

  public static final String X = "X";
  public static final String O = "O";

  private final String[][] cells = new String[3][3];

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
    cells[row][col] = counter;
  }
}
