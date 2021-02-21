package com.github.mrsarm.nqueen.app;

import java.util.Optional;

import com.github.mrsarm.nqueen.BacktrackingNQueen;
import com.github.mrsarm.nqueen.NQueen;

/**
 * Main class to execute the app from the command-line.
 */
public class App {
    public static void main(String[] args) {
        NQueen nqueen = new BacktrackingNQueen(parseSize(args));
        Optional<boolean[][]> result = nqueen.solve();
        if(result.isPresent()) {
            System.out.println(nqueen.boardToString());
            //System.out.println(nqueen.boardToString("\uD83D\uDC51", "\uD83D\uDD32", "", "\n")); //-> 👑 Unicode queens
        } else {
            System.err.println("Solution does not exist.");
        }
    }

    private static int parseSize(String[] args) {
        int size = 8;
        if (args.length > 0) {
            try {
                size = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Wrong board size: " + args[0]);
                System.exit(-1);
            }
        }
        return size;
    }
}
