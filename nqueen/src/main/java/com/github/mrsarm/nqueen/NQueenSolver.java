package com.github.mrsarm.nqueen;

import java.util.Optional;


/**
 * Solve the NQueen problem placing
 * the queens in the board.
 *
 * Please note that may be more than one
 * solution, but classes that implements this
 * interface intents to return one of the
 * feasible solutions.
 *
 * Just create an instance of an implementation class
 * and call {@link #solve(int)} with the size of the
 * board, and it will return an Optional: empty
 * if the board does not have a solution, or
 * with an object that implements {@link NQueenBoard}
 * with the result on it.
 *
 * @author Mariano Ruiz
 */
public interface NQueenSolver {

    Optional<NQueenBoard> solve(int boardLength);
}
