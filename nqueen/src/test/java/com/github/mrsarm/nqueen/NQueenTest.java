package com.github.mrsarm.nqueen;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class NQueenTest {

    @Test public void testBoardToStringEmptyBoard() {
        NQueen nqueen = new NQueen() {
            @Override public Optional<boolean[][]> solve() {
                return Optional.empty();
            }
            @Override public int getBoardLength() {
                return 0;
            }
        };
        assertEquals("", nqueen.boardToString());
    }

    @Test public void testBoardToString() {
        NQueen nqueen = new NQueen() {
            @Override public Optional<boolean[][]> solve() {
                return Optional.of(
                    new boolean[][]{
                        {false, false, true , false},
                        {true , false, false, false},
                        {false, false, false, true },
                        {false, true , false, false},
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
            "0  1  0  0",
            nqueen.boardToString());
    }

    @Test public void testBoardToStringCustomizedStrings() {
        NQueen nqueen = new NQueen() {
            @Override public Optional<boolean[][]> solve() {
                return Optional.of(
                    new boolean[][]{
                        {false, false, true , false},
                        {true , false, false, false},
                        {false, false, false, true },
                        {false, true , false, false},
                    }
                );
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
            nqueen.boardToString("1", "0", ", ", "<br/>\n"));
    }

    @Test public void testBoardToStringUnicodeAlsoWorks() {
        NQueen nqueen = new NQueen() {
            @Override public Optional<boolean[][]> solve() {
                return Optional.of(
                    new boolean[][]{
                        {false, false, true , false},
                        {true , false, false, false},
                        {false, false, false, true },
                        {false, true , false, false},
                    }
                );
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
            nqueen.boardToString("\uD83D\uDC51", "\uD83D\uDD32"));
    }
}
