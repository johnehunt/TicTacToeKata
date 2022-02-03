package com.jjh.tictactoe;

public class Board {

  public static final String X = "X";
  public static final String Y = "O";

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

  public void addCounter(String counter, int row, int col) {
    cells[row][col] = counter;
  }
}
