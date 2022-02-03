package com.jjh.tictactoe;

import java.util.Objects;

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

  public boolean isWin(String counter) {
    return (// Across the top
      (cellContains(counter, 0, 0) && cellContains(counter, 0, 1) && cellContains(counter, 0, 2)) ||
        // Across the middle
        (cellContains(counter, 1, 0) && cellContains(counter, 1, 1) && cellContains(counter, 1, 2)) ||
        // Across the bottom
        (cellContains(counter, 2, 0) && cellContains(counter, 2, 1) && cellContains(counter, 2, 2)) ||
        // down the left side
        (cellContains(counter, 0, 0) && cellContains(counter, 1, 0) && cellContains(counter, 2, 0)) ||
        // down the middle
        (cellContains(counter, 0, 1) && cellContains(counter, 1, 1) && cellContains(counter, 2, 1)) ||
        // down the right side
        (cellContains(counter, 0, 2) && cellContains(counter, 1, 2) && cellContains(counter, 2, 2)) ||
        // diagonal
        (cellContains(counter, 0, 0) && cellContains(counter, 1, 1) && cellContains(counter, 2, 2)) ||
        // other diagonal
        (cellContains(counter, 0, 2) && cellContains(counter, 1, 1) && cellContains(counter, 2, 0))
    );
  }

  private boolean cellContains(String counter, int row, int column) {
    return Objects.equals(cells[row][column], counter);
  }

  /**
   * Method useful for debugging and user interaction
   */
  public void printBoard() {
    for (int i=0; i< cells.length; i++) {
      System.out.println("-------");
      for (int j=0; j<cells[i].length; j++) {
        System.out.print("|%s".formatted(cells[i][j]));
      }
      System.out.println(("|"));
    }
    System.out.println("-------");
  }

}
