package com.github.mrsarm.nqueen.app;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import com.github.mrsarm.nqueen.*;

/**
 * Main class to execute the app from the command-line.
 */
public class App {
    public static void main(String[] args) {
        try {
            NQueenSolver nQueenSolver;
            if (parseClassic(args)) {
                nQueenSolver = new BacktrackingQueenSolver();       // Classic N-Queen
            } else {
                nQueenSolver = new BacktrackingLoneQueenSolver();   // No straight lines version
            }
            NQueenBoard board = nQueenSolver.solve(parseSize(args)).get();
            if (parsePretty(args)) {
                //-> 👑 Unicode queens !
                // Not all terminals support unicode, so it is not the default
                System.out.println(
                    board.boardToString("\uD83D\uDC51", "\uD83D\uDD32", "", "\n"));
            } else {
                System.out.println(
                    //nqueen.boardToString("true ", "false", ", ", "},\n"));
                    board.boardToString());
            }
        } catch (NoSuchElementException e) {
            System.out.println("Solution does not exist.");
        } catch (Exception e) {
            System.err.println("nqueen-problem error - " + e.getMessage());
            //e.printStackTrace();
        }
    }

    private static int parseSize(String[] args) {
        return Stream.of(args)
            .filter(arg -> !"--pretty".equals(arg) &&  !"--classic".equals(arg))
            .map(arg -> {
                try {
                    return Integer.parseInt(arg);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Illegal board size: " + arg + ". Is not a number");
                }
            })
            .findFirst().orElse(8); // Default board size: 8
    }

    private static boolean parsePretty(String[] args) {
        return Stream.of(args).anyMatch("--pretty"::equals);
    }

    private static boolean parseClassic(String[] args) {
        return Stream.of(args).anyMatch("--classic"::equals);
    }
}
