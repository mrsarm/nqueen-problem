package com.github.mrsarm.nqueen;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class BacktrackingNQueenTest {

    @Test public void test1Queen() {
        NQueen nqueen = new BacktrackingNQueen(1);
        Optional<boolean[][]> result = nqueen.solve();
        assertTrue(result.isPresent());
        boolean[][] board = result.get();   // it fails if there are no results
        assertArrayEquals(
            board,
            new boolean[][]{
                {true},
            });
    }

    @Test public void test2QueenNoResult() {
        NQueen nqueen = new BacktrackingNQueen(2);
        Optional<boolean[][]> result = nqueen.solve();
        assertFalse(result.isPresent());
    }

    @Test public void test3QueenNoResult() {
        NQueen nqueen = new BacktrackingNQueen(3);
        Optional<boolean[][]> result = nqueen.solve();
        assertFalse(result.isPresent());
    }

    @Test public void test4Queen() {
        NQueen nqueen = new BacktrackingNQueen(4);
        Optional<boolean[][]> result = nqueen.solve();
        assertTrue(result.isPresent());
        boolean[][] board = result.get();   // it fails if there are no results
        assertArrayEquals(
            board,
            new boolean[][]{
                {false, false, true , false},
                {true , false, false, false},
                {false, false, false, true },
                {false, true , false, false},
            });
    }

    @Test public void test8Queen() {
        NQueen nqueen = new BacktrackingNQueen();
        Optional<boolean[][]> result = nqueen.solve();
        assertTrue(result.isPresent());
        boolean[][] board = result.get();   // it fails if there are no results
        assertArrayEquals(
            board,
            new boolean[][]{
                {true , false, false, false, false, false, false, false},
                {false, false, false, false, false, false, true , false},
                {false, false, false, false, true , false, false, false},
                {false, false, false, false, false, false, false, true },
                {false, true , false, false, false, false, false, false},
                {false, false, false, true , false, false, false, false},
                {false, false, false, false, false, true , false, false},
                {false, false, true , false, false, false, false, false},
            });
    }

    @Test public void testNegativeQueenException() {
        try {
            new BacktrackingNQueen(-2);
            throw new RuntimeException("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals(
                "Illegal size = -2. BacktrackingNQueen size must be higher than 0",
                e.getMessage()
            );
        }
    }

    @Test public void testCall2TimesGetSameComputedResult() {
        NQueen nqueen = new BacktrackingNQueen(4);
        Optional<boolean[][]> result1 = nqueen.solve();
        Optional<boolean[][]> result2 = nqueen.solve();
        // Same object
        assertTrue(result1.get() == result2.get());
        // Same result (despite same object, the values
        assertArrayEquals(result1.get(), result2.get());
    }
}
