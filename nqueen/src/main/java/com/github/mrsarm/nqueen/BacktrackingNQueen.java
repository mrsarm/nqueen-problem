package com.github.mrsarm.nqueen;

import java.util.Optional;

/**
 * Class to solve N Queen Problem using the
 * backtracking algorithm.
 *
 * Once the object created with the size
 * of the board, the computation of the
 * result is done with {@link #solve()},
 * that returns a optional object containing
 * an array with the result, if there is one.
 *
 * The class is immutable once computed the results,
 * so calling the method to get the results again will
 * return the same array.
 *
 * The class is not thread-safe, if you are in the crazy
 * situation where you need to sync the result computed
 * by {@link #solve()}, just implement a wrapper class
 * to hold object and call the computation in a sync fashion.
 *
 * @author Mariano Ruiz
 */
public class BacktrackingNQueen implements NQueen {

    private int size;
    private boolean board[][];
    private boolean solved, result;

    public BacktrackingNQueen() {
        this.size = 8;
        this.board = new boolean[this.size][this.size];
    }

    public BacktrackingNQueen(int size) {
        if (size < 1) {
            throw new IllegalArgumentException(
                "Illegal size = " + size + ". " +
                "BacktrackingNQueen size must be higher than 0");
        }
        this.size = size;
        this.board = new boolean[this.size][this.size];
    }

    /* A utility function to check if a queen can 
    be placed on board[row][col]. Note that this 
    function is called when "col" queens are already 
    placeed in columns from 0 to col -1. So we need 
    to check only left side for attacking queens */
    boolean isSafe(boolean board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i])
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j])
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < size; i++, j--)
            if (board[i][j])
                return false;

        return true;
    }

    /* A recursive utility function to solve N 
    Queen problem */
    boolean solveNQUtil(boolean board[][], int col) {
		/* base case: If all queens are placed 
		then return true */
        if (col >= size)
            return true; 

		/* Consider this column and try placing 
		this queen in all rows one by one */
        for (int i = 0; i < size; i++) {
			/* Check if the queen can be placed on 
			board[i][col] */
            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = true;

                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1) == true)
                    return true; 

				/* If placing queen in board[i][col] 
				doesn't lead to a solution then 
				remove queen from board[i][col] */
                board[i][col] = false; // BACKTRACK
            }
        } 

		/* If the queen can not be placed in any row in 
		this colum col, then return false */
        return false;
    }

    /* This function solves the N Queen problem using 
    Backtracking. It mainly uses solveNQUtil () to 
    solve the problem. It returns false if queens 
    cannot be placed, otherwise, return true and 
    prints placement of queens in the form of 1s. 
    Please note that there may be more than one 
    solutions, this function prints one of the 
    feasible solutions.*/
    @Override
    public Optional<boolean[][]> solve() {
        if (!solved) {
            result = solveNQUtil(board, 0);
            solved = true;
        }
        if (result) {
            return Optional.of(board);
        }
        return Optional.empty();
    }

    @Override
    public int getBoardLength() {
        return size;
    }

    @Override
    public String toString() {
        return boardToString();
    }
}
