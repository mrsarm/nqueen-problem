package com.github.mrsarm.nqueen;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class NQueenBoardTest {

    @Test public void testBoardToString() {
        NQueenBoard board = new NQueenBoard() {
            @Override public boolean[][] getBoard() {
                return new boolean[][]{
                    {false, false, true , false},
                    {true , false, false, false},
                    {false, false, false, true },
                    {false, true , false, false},
                };
            }
            @Override public int getBoardLength() {
                return 4;
            }
        };
        assertEquals(
            "0  0  1  0\n" +
            "1  0  0  0\n" +
            "0  0  0  1\n" +
            "0  1  0  0",
            board.boardToString());
    }

    @Test public void testNegativeQueenException() {
        try {
            new TupleNQueenBoard(-2);   // class implementation
            throw new RuntimeException("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals(
                "Illegal board size: -2. Must be higher than 0",
                e.getMessage()
            );
        }
    }

    @Test public void testBoardToStringCustomizedStrings() {
        NQueenBoard board = new NQueenBoard() {
            @Override public boolean[][] getBoard() {
                return new boolean[][]{
                    {false, false, true , false},
                    {true , false, false, false},
                    {false, false, false, true },
                    {false, true , false, false},
                };
            }
            @Override public int getBoardLength() {
                return 4;
            }
        };
        assertEquals(
            "0, 0, 1, 0<br/>\n" +
            "1, 0, 0, 0<br/>\n" +
            "0, 0, 0, 1<br/>\n" +
            "0, 1, 0, 0",
            board.boardToString("1", "0", ", ", "<br/>\n"));
    }

    @Test public void testBoardToStringUnicodeAlsoWorks() {
        NQueenBoard board = new NQueenBoard() {
            @Override public boolean[][] getBoard() {
                return new boolean[][]{
                    {false, false, true , false},
                    {true , false, false, false},
                    {false, false, false, true },
                    {false, true , false, false},
                };
            }
            @Override public int getBoardLength() {
                return 4;
            }
        };
        assertEquals(
            "🔲  🔲  👑  🔲\n" +
            "👑  🔲  🔲  🔲\n" +
            "🔲  🔲  🔲  👑\n" +
            "🔲  👑  🔲  🔲",
            board.boardToString("\uD83D\uDC51", "\uD83D\uDD32"));
    }
}
