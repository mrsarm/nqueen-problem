package com.github.mrsarm.nqueen;


/**
 * Implementation of NQueenBoard that instead of
 * having a 2D array of cells, it has a single
 * array where each cell represents a row
 * in the board, and the integer value is
 * the column position of the queen in
 * that row (zero indexed).
 */
public class TupleNQueenBoard implements NQueenBoard {

    // Tuple [C0, C1, C2, ..., Cn, ..., Csize-1] where Cn value
    // represents the column number (zero-indexed) on which
    // the queen is placed for the row "n".
    // All the tuple's cells are initialized with -1 value that
    // means no value has been placed yet
    private int [] tupleBoard;

    // size of the board sides
    private int length;

    /**
     * Creates a board of 8 × 8 cells.
     * All the cells are initialized with -1,
     * which means the no queen was placed
     * in the rows yet.
     */
    public TupleNQueenBoard() {
        this.length = 8;
        this.tupleBoard = createTupleBoard();
    }

    /**
     * Creates a queens board of length × length cells.
     * All the cells are initialized with -1,
     * which means the no queen was placed
     * in the rows yet.
     *
     * @throws IllegalArgumentException if length < 1
     */
    public TupleNQueenBoard(int length) {
        if (length < 1) {
            throw new IllegalArgumentException(
                "Illegal board size: " + length + ". " +
                    "Must be higher than 0");
        }
        this.length = length;
        this.tupleBoard = createTupleBoard();
    }

    @Override public boolean[][] getBoard() {
        // Converts the tuple representation of the board
        // in a 2D board where each cell that has a
        // queen placed has a `true` value
        boolean [][] board = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            board[i][tupleBoard[i]] = true;
        }
        return board;
    }

    public int[] getTupleBoard() {
        return tupleBoard;
    }

    @Override public int getBoardLength() {
        return length;
    }

    private int [] createTupleBoard() {
        int [] tupleBoard = new int[this.length];
        for (int i = 0; i < this.length; i++) tupleBoard[i] = -1;
        return tupleBoard;
    }

    /**
     * A string representation of the board
     * for debugging purpose. Queens are "1"
     * and empty cells "0".
     *
     * @see NQueenBoard#boardToString(String, String, String, String)
     */
    @Override public String toString() {
        return this.boardToString();
    }
}
