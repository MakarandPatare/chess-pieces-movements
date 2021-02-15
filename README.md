# chess-pieces-movements

Chessboard:

The chessboard is an 8 x 8 grid with 64 cells in it.
With 8 rows (A, B, C.... H) and 8 columns (1, 2, 3.... 8), each cell can be uniquely identified with its cell number. This can be seen illustrated below.

Chess pieces and their movements:

The game of chess has 6 unique types of pieces, with their own unique types of movements. 

These are:

1. King – Can move only 1 step at a time in all 8 directions (horizontal, vertical and diagonal)
2. Queen – Can move across the board in all 8 directions
3. Bishop – Can move across the board only diagonally
4. Horse – Can move across the board only in 2.5 steps (2 vertical steps and 1 horizontal step)
5. Rook – Can move across the board only vertically and horizontally
6. Pawn – Can move only 1 step at a time, in the forward direction, vertically. Can also move 1 step forward diagonally, in order to eliminate an opposing piece.

Objective of the program:

Program should simulate the movement of each unique chess piece on an
empty chessboard.

• Input – The input string to the program will be the Type of chess piece and
its Position (cell number) on the chessboard. E.g. “King D5”

• Output – Once you execute the program, the output will be a string of all
possible cells in which the chess piece can move.

Sample inputs and outputs:

Input – “King D5”
Output – “E5, E6, D6, C6, C5, C4, D4, E4”

Input – “Horse E3”
Output – “G4, F5, D5, C4, C2, D1, F1”

Assumption:

Assume that the board is empty. This means that the pawn cannot move diagonally.

Solution: 

Setup: 

1. git clone
2. sbt clean compile
3. sbt test

Running/Testing the code: 

• ChessMovementsApp object is the entry point and you can call output method with desired inputs or 
• You can run test cases and modify them for testing different scenarios
