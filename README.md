# TicTacToeKata
A kata illustrating TicTacToe

The following illustrates the steps in this Kata

Step 1 - Initial Board set up and confirm board is empty

Step 2 - Add ability to place a counter in a cell

Adds an add counter method
Updates functionality of isEmpty

Step 3 - Confirm counter places in correct cell

Does this by adding a counter to a specific cell and then checking to see if that cell is empty or not.
Adds whether a cell is empty or not.

Step 4 - Check for adding the same counter twice in sequence

Adds multiple additions to board X, O and X

Step 5 Check can't add a counter to a filled cell

Adds CellNotAvailableException
Adds check for empty cell in addCounter

Step 6 - Check for ordering of counters
Can't add two counters of the same type (e.g. two X counters) one after another

 * Adds OutOfSequenceException
 * Board keeps a record of the last player to make a move
 * Checks player when adding a counter

Step 7 - Checks can't add different counters to the same cell

Step 8 - Check for a full board or not

Adds isFull to Board class

Step 9 - Checks for a win for a player

Adds isWin(counter) to Board class

