package com.github.mrsarm.nqueen;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class NQueenTest {

    @Test public void testBoardToStringEmptyBoard() {
        NQueen nqueen = new NQueen() {
            @Override public Optional<int[][]> solve() {
                return Optional.empty();
            }
            @Override public int getBoardLength() {
                return 0;
            }
        };
        assertEquals("", nqueen.boardToString());
    }

    @Test public void testBoardToStringLength4Board() {
        NQueen nqueen = new NQueen() {
            @Override public Optional<int[][]> solve() {
                return Optional.of(
                    new int[][]{
                        {0, 0, 1, 0},
                        {1, 0, 0, 0},
                        {0, 0, 0, 1},
                        {0, 1, 0, 0},
                    }
                );
            }
            @Override public int getBoardLength() {
                return 4;
            }
        };
        assertEquals(
            "0  0  1  0\n" +
                "1  0  0  0\n" +
                "0  0  0  1\n" +
                "0  1  0  0\n",
            nqueen.boardToString());
    }

    @Test public void testBoardToStringLength4BoardAndDiffSeparator() {
        NQueen nqueen = new NQueen() {
            @Override public Optional<int[][]> solve() {
                return Optional.of(
                    new int[][]{
                        {0, 0, 1, 0},
                        {1, 0, 0, 0},
                        {0, 0, 0, 1},
                        {0, 1, 0, 0},
                    }
                );
            }
            @Override public int getBoardLength() {
                return 4;
            }
        };
        assertEquals(
            "0, 0, 1, 0|\n" +
                "1, 0, 0, 0|\n" +
                "0, 0, 0, 1|\n" +
                "0, 1, 0, 0|\n",
            nqueen.boardToString(", ", "|\n"));
    }
}
