package com.shpp.p2p.cs.dbelinskyi.assignment1;

import com.shpp.p2p.cs.dbelinskyi.SuperKarel;

/**
 * Task 1 - Rows of pebbles
 * Each column must become complete
 * Karel starts in the southwest corner, looks east, the number of
 * beepers is unlimited (almost)
 * The columns are on the 1st, 5th, 9th row, etc. (the same distance),
 * but there can be one column, its height is also not fixed
 * The last column is close to the edge
 * All columns start at the same level
 * Do not place beepers where they already lie
 */
public class Assignment1Part1 extends SuperKarel {
    public void run() throws Exception {
        /**
         * First we build a column
         * Then we go down
         * We move on to building the next one
         * We repeat the algorithm until we hit the wall
         */
        while (frontIsClear()) {
            turnLeft();         //Turning Karel to readiness for construction
            buildColumn();
            getOnTheGround();
            moveToTheNextColumn();
        }
        ;
        //Considering edge cases
        turnLeft();
        buildColumn();
    }

    /**
     * Prerequisite: Karel looks north, ready to begin building the column
     * Result: Karel stands on top of the erected column
     */
    private void buildColumn() throws Exception {
        while (frontIsClear()) {
            fillEmptyCell();
            move();
        }
        fillEmptyCell();
    }

    /**
     * Prerequisite: Karel stands on top of the erected column, looking north.
     * Result: Karel has descended to the ground, looking south.
     */
    private void getOnTheGround() throws Exception {
        turnAround();
        moveToTheWall();
    }

    /**
     * Prerequisite: Karel stands under a built column, looking south.
     * Result: Karel moved to the next column, looking north.
     */
    private void moveToTheNextColumn() throws Exception {
        turnLeft();
        for (int i = 0; i < 4; i++) {
            if (frontIsClear()) {
                move();
            }
        }
    }

    /**
     * Prerequisite: Karel builds a column, looks north, there can be either an empty or a filled cell under it
     * Result: The cell becomes filled with one beeper
     */
    private void fillEmptyCell() throws Exception {
        if (noBeepersPresent()) {
            putBeeper();
        }
    }
}