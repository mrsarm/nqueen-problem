package com.github.mrsarm.nqueen;

/**
 * Chess board representation where
 * only queens are placed, and the
 * board can have any size greater
 * than 0 (square size).
 */
public interface NQueenBoard {

    /**
     * Returns an array with the board, where
     * each cell has a true value if there
     * is a queen placed.
     */
    boolean [][] getBoard();

    /**
     * The length of any of the sides of the square board.
     */
    int getBoardLength();

    /**
     * Returns a string representation of the board
     * for debugging purpose.
     *
     * @param queenCell the string to use for the queens in
     *                  the board, like "1", a "X" cross
     *                  or even a unicode queen 👑
     * @param emptyCell the string to use for empty cells,
     *                  like a blank space " " or a zero "0"
     *                  string
     * @param colSeparator the string to separate cells, like
     *                     one or more blank spaces "  "
     * @param rowSeparator the string to separate the rows,
     *                     normally a new line character "\n",
     *                     but can be also other useful
     *                     separators like "<br/>" for
     *                     HTML outputs
     */
    default String boardToString(
        String queenCell,
        String emptyCell,
        String colSeparator,
        String rowSeparator
    ) {
        boolean[][] board = getBoard();
        int length = getBoardLength();

        StringBuilder buff = new StringBuilder(
            length * length * (queenCell.length() + colSeparator.length())
                + (length * rowSeparator.length())
        );
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j!=0) buff.append(colSeparator);
                buff.append(board[i][j] ? queenCell : emptyCell);
            }
            if (i!=length-1) buff.append(rowSeparator);
        }
        return buff.toString();
    }

    /**
     * A string representation of the board
     * for debugging purpose.
     *
     * It uses two empty spaces to separate columns
     * and a new line "\n" string to separate rows
     *
     * @see #boardToString(String, String, String, String)
     */
    default String boardToString(
        String queenCell,
        String emptyCell
    ) {
        return boardToString(queenCell, emptyCell, "  ", "\n");
    }

    /**
     * A string representation of the board
     * for debugging purpose. Queens are 1
     * and empty cells 0.
     *
     * @see #boardToString(String, String, String, String)
     */
    default String boardToString() {
        return boardToString("1", "0", "  ", "\n");
    }
}
