package com.github.mrsarm.nqueen;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class BacktrackingQueenSolverTest {

    @Test public void test1Queen() {
        Optional<NQueenBoard> queenBoard = new BacktrackingQueenSolver().solve(1);
        assertTrue(queenBoard.isPresent());
        boolean[][] board = queenBoard.get().getBoard();   // it fails if there are no results
        assertArrayEquals(
            board,
            new boolean[][]{
                {true},
            });
    }

    @Test public void test2QueenNoResult() {
        Optional<NQueenBoard> queenBoard = new BacktrackingQueenSolver().solve(2);
        assertFalse(queenBoard.isPresent());
    }

    @Test public void test3QueenNoResult() {
        Optional<NQueenBoard> queenBoard = new BacktrackingQueenSolver().solve(3);
        assertFalse(queenBoard.isPresent());
    }

    @Test public void test4Queen() {
        Optional<NQueenBoard> queenBoard = new BacktrackingQueenSolver().solve(4);
        assertTrue(queenBoard.isPresent());
        boolean[][] board = queenBoard.get().getBoard();    // it fails if there are no results
        assertArrayEquals(
            board,
            new boolean[][]{
                {false, true , false, false},
                {false, false, false, true },
                {true , false, false, false},
                {false, false, true , false},
            });
    }

    @Test public void test5Queen() {
        Optional<NQueenBoard> queenBoard = new BacktrackingQueenSolver().solve(5);
        assertTrue(queenBoard.isPresent());
        boolean[][] board = queenBoard.get().getBoard();
        assertArrayEquals(
            board,
            new boolean[][]{
                {true , false, false, false, false},
                {false, false, true , false, false},
                {false, false, false, false, true },
                {false, true , false, false, false},
                {false, false, false, true , false},
            });
    }

    @Test public void test6Queen() {
        Optional<NQueenBoard> queenBoard = new BacktrackingQueenSolver().solve(6);
        assertTrue(queenBoard.isPresent());
        boolean[][] board = queenBoard.get().getBoard();
        assertArrayEquals(
            board,
            new boolean[][]{
                {false, true , false, false, false, false},
                {false, false, false, true , false, false},
                {false, false, false, false, false, true },
                {true , false, false, false, false, false},
                {false, false, true , false, false, false},
                {false, false, false, false, true , false},
            });
    }

    @Test public void test8Queen() {
        Optional<NQueenBoard> queenBoard = new BacktrackingQueenSolver().solve(8);
        assertTrue(queenBoard.isPresent());
        boolean[][] board = queenBoard.get().getBoard();
        assertArrayEquals(
            board,
            new boolean[][]{
                {true , false, false, false, false, false, false, false},
                {false, false, false, false, true , false, false, false},
                {false, false, false, false, false, false, false, true },
                {false, false, false, false, false, true , false, false},
                {false, false, true , false, false, false, false, false},
                {false, false, false, false, false, false, true , false},
                {false, true , false, false, false, false, false, false},
                {false, false, false, true , false, false, false, false},
            });
    }

    @Test public void test12Queen() {
        Optional<NQueenBoard> queenBoard = new BacktrackingQueenSolver().solve(12);
        assertTrue(queenBoard.isPresent());
        boolean[][] board = queenBoard.get().getBoard();
        assertArrayEquals(
            board,
            new boolean[][]{
                {true , false, false, false, false, false, false, false, false, false, false, false},
                {false, false, true , false, false, false, false, false, false, false, false, false},
                {false, false, false, false, true , false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, true , false, false, false, false},
                {false, false, false, false, false, false, false, false, false, true , false, false},
                {false, false, false, false, false, false, false, false, false, false, false, true },
                {false, false, false, false, false, true , false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false, true , false},
                {false, true , false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, true , false, false, false, false, false},
                {false, false, false, false, false, false, false, false, true , false, false, false},
                {false, false, false, true , false, false, false, false, false, false, false, false},
            });
    }
}
