package com.github.mrsarm.nqueen;

import java.util.Optional;

/**
 * Class to solve N Queen Problem using the
 * backtracking algorithm.
 *
 * @author Mariano Ruiz
 */
public class BacktrackingQueenSolver implements NQueenSolver {

    @Override
    public Optional<NQueenBoard> solve(int boardLength) {
        TupleNQueenBoard board = new TupleNQueenBoard(boardLength);
        if (solve(board, 0)) {
            return Optional.of(board);
        }
        return Optional.empty();
    }

    /* A recursive utility function to solve N
    Queen problem */
    boolean solve(TupleNQueenBoard board, int row) {
		/* base case: If all queens are placed
		then return true */
        int length = board.getBoardLength();
        int [] tupleBoard = board.getTupleBoard();

        if (row >= length)
            return true;

		/* Consider this row and try placing
		this queen in all columns one by one */
        for (int i = 0; i < length; i++) {
			/* Check if the queen can be placed on
			tupleBoard[i][col] (tupleBoard[row] = i) */
            if (isSafe(tupleBoard, row, i)) {
                /* Place this queen in board[row][i] */
                tupleBoard[row] = i;

                /* recur to place rest of the queens */
                if (solve(board, row + 1))
                    return true;

				/* If placing queen in board[row][i]
				doesn't lead to a solution then
				remove queen from board[row][i] */
                tupleBoard[row] = -1;   // BACKTRACK
            }
        }

		/* If the queen can not be placed in any col in
		this row, then return false */
        return false;
    }

    /* A utility function to check if a queen can
    be placed on board[row][col]. Note that this
    function is called when "row" queens are already
    placed in rows from 0 to row-1. So we need to check
    only upper side of the board for attacking queens */
    boolean isSafe(int [] tupleBoard, int row, int col) {
        // Check column. The row is not checked
        // because we know the row is still empty
        // as mentioned above
        int irow;
        for (irow = 0; tupleBoard[irow] != -1; irow++) {
            if (tupleBoard[irow] == col)
                return false;
        }

        int jcol;
        /* Check upper diagonal on left side */
        for (irow = row, jcol = col; irow >= 0 && jcol >= 0; irow--, jcol--)
            if (tupleBoard[irow] == jcol)
                return false;

        /* Check upper diagonal on right side */
        for (irow = row, jcol = col; irow >= 0 && jcol < tupleBoard.length; irow--, jcol++)
            if (tupleBoard[irow] == jcol)
                return false;

        return true;
    }
}
