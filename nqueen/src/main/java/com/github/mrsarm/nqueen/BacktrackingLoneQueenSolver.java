package com.github.mrsarm.nqueen;


/**
 * Class to solve N Queen Problem using the
 * backtracking algorithm, plus the condition that
 * no 3 queens can be in a straight line at ANY angle.
 *
 * @author Mariano Ruiz
 */
public class BacktrackingLoneQueenSolver extends BacktrackingQueenSolver {

    @Override boolean isSafe(int [] tupleBoard, int row, int col) {
        if (super.isSafe(tupleBoard, row, col)) {
            if (row < 2) return true;   // there are no 3 queens in the board yet
            int maxCol = tupleBoard.length - 1;

            // Check straight collisions --> false
            // Given 3 queens, q0 (x0, y0), q1 (x1, y1) and q3 (x3, y3),
            // they are collinear (in a straight line) if
            // (y1 - y0) / (x1 - x0) == (y2 - y0) / (x2 - x0)
            int x0 = row, y0 = col;
            for (int i1=row-1; i1 >= 1; i1--) {
                int x1 = i1, y1 = tupleBoard[i1];

                if (y1 == 0 || y1 == maxCol)        // Little optimization: cannot be straight line
                    continue;                       // if second queen is at the edge of the board

                for (int i2=i1-1; i2 >= 0; i2--) {
                    int x2 = i2, y2 = tupleBoard[i2];
                    if ((y0 < y1 && y1 > y2) ||     // Little optimization: cannot be straight line
                        (y0 > y1 && y1 < y2)) {     // if col value increases and then
                        continue;                   // decreases, or the opposite
                    }

                    // Doing (y1 - y0) / (x1 - ... would produce float numbers hard to compare,
                    // so lets compare the fractions numerators, using a common denominator

                    long num0 = y1 - y0,    // long type is used to avoid overflow
                        den0 = x1 - x0,    // when multiplying (unlikely though)
                        num1 = y2 - y0,
                        den1 = x2 - x0;
                    num0 = num0 * den1;     // The common denominator used
                    num1 = num1 * den0;     // is the product of both denominators
                    if (num0 == num1)
                        return false;
                }
            }
            return true;
        }
        return false;
    }
}
