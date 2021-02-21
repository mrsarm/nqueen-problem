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
    Optional<int[][]> solve();

    /**
     * Return the length of board sides
     */
    int getBoardLength();

    /**
     * A string representation of the board
     * for debugging purpose.
     * Return empty string if there is no solution.
     */
    default String boardToString(String colSeparator, String lineSeparator) {
        Optional<int[][]> board = solve();
        return board.map(ints -> {
            int length = getBoardLength();
            StringBuilder buff = new StringBuilder(
                length * length * (colSeparator.length()+1) + (length * lineSeparator.length())
            );
            final int capacity = buff.capacity();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (j!=0) buff.append(colSeparator);
                    buff.append(ints[i][j]);
                }
                buff.append(lineSeparator);
            }
            return buff.toString();
        })
        .orElse("");
    }

    default String boardToString() {
        return boardToString("  ", "\n");
    }
}
