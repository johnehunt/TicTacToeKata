package com.jjh.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BoardTest {

  private Board board;

  @BeforeEach
  void setUp() {
    board = new Board();
  }

  @AfterEach
  void tearDown() {
    board = null;
  }

  @Test
  void isBoardEmpty() {
    boolean result = board.isEmpty();
    assertThat("the board should be empty", result, equalTo(true));
  }

  @Test
  void isCellEmpty() {
    boolean result = board.isCellEmpty(0,0);
    assertThat("the board should be empty", result, equalTo(true));
  }

  @Test
  void addXCounterAtZeroByZero() {
    board.addCounter(Board.X, 0, 0);
    boolean result = board.isEmpty();
    assertThat("with a X counter in cell 0,0 the board should not be empty", result, equalTo(false));
  }

  @Test
  void addYCounterAtZeroByZero() {
    board.addCounter(Board.Y, 0, 0);
    boolean result = board.isEmpty();
    assertThat("with a Y counter in cell 0,0 the board should not be empty", result, equalTo(false));
  }

  @Test
  void addXCounterAtZeroByZeroCheckCell() {
    int row = 0;
    int col = 0;
    board.addCounter(Board.X, row, col);
    boolean result = board.isCellEmpty(row, col);
    assertThat("with a X counter in cell 0,0 the cell should not be empty", result, equalTo(false));
  }

  @Test
  void addYCounterAtZeroByZeroCheckCell() {
    int row = 0;
    int col = 0;
    board.addCounter(Board.Y, row, col);
    boolean result = board.isCellEmpty(row, col);
    assertThat("with a Y counter in cell 0,0 the cell should not be empty", result, equalTo(false));
  }

}
