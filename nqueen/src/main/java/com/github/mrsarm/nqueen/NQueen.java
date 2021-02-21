package com.github.mrsarm.nqueen;

import java.util.Optional;

public interface NQueen {

    /**
     * Solve the NQueen problem placing
     * the queens in the board.
     *
     * The implementation should compute
     * the result once, and then subsequent
     * calls return the same result, but
     * not required by design.
     *
     * @return an optional container with an
     *         array with the solution, or
     *         an empty optional container
     *         if there is no solution
     */
    Optional<boolean[][]> solve();

    /**
     * Return the length of board sides
     */
    int getBoardLength();

    /**
     * A string representation of the board
     * for debugging purpose.
     *
     * Return empty string if there is no solution.
     */
    default String boardToString(
        String queenCell,
        String emptyCell,
        String colSeparator,
        String rowSeparator
    ) {
        Optional<boolean[][]> board = solve();
        return board.map(cells -> {
            int length = getBoardLength();
            StringBuilder buff = new StringBuilder(
                length * length * (queenCell.length() + colSeparator.length())
                    + (length * rowSeparator.length())
            );
            final int capacity = buff.capacity();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (j!=0) buff.append(colSeparator);
                    buff.append(cells[i][j] ? queenCell : emptyCell);
                }
                if (i!=length-1) buff.append(rowSeparator);
            }
            return buff.toString();
        })
        .orElse("");
    }

    /**
     * A string representation of the board
     * for debugging purpose. Queens are 1
     * and empty cells 0.
     *
     * Return empty string if there is no solution.
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
     * Return empty string if there is no solution.
     */
    default String boardToString() {
        return boardToString("1", "0", "  ", "\n");
    }
}
