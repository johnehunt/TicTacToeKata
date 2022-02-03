package com.jjh.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
  void addOCounterAtZeroByZero() {
    board.addCounter(Board.O, 0, 0);
    boolean result = board.isEmpty();
    assertThat("with a O counter in cell 0,0 the board should not be empty", result, equalTo(false));
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
  void addOCounterAtZeroByZeroCheckCell() {
    int row = 0;
    int col = 0;
    board.addCounter(Board.O, row, col);
    boolean result = board.isCellEmpty(row, col);
    assertThat("with a O counter in cell 0,0 the cell should not be empty", result, equalTo(false));
  }

  @Test
  void addSameCounterTwiceToSameCell() {
    int row = 0;
    int col = 0;
    board.addCounter(Board.X, row, col);
    board.addCounter(Board.O, row+1, col+1);
    assertThrows(CellNotAvailableException.class, () -> board.addCounter(Board.X, row, col));
  }

  @Test
  void addXFollowedByOCountersInARow() {
    board.addCounter(Board.X, 0,0);
    board.addCounter(Board.O, 0,1);
    boolean result = board.isCellEmpty(0, 1);
    assertThat("with a O counter in cell 0,1 the cell should not be empty", result, equalTo(false));
  }

  @Test
  void addTwoXCountersInARow() {
    board.addCounter(Board.X, 0,0);
    assertThrows(OutOfSequenceException.class, () -> board.addCounter(Board.X, 0,1));
  }

}
