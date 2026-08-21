package com.shpp.p2p.cs.dbelinskyi.assignment1;

public class Assignment1Part3 extends SuperKarel {
    /**
     * Problem 3 - Chessboard
     * A RECTANGLE IS NOT JUST A SQUARE
     * One of the placed beepers must be in the southwest corner of the map
     * Karel starts from the southwest corner, looking east
     * Length or width can be 1
     * It is not necessary to invent some cool optimization
     * The main task is to place the beepers in the way
     * the black squares on the chessboard are located
     */
    public void run() throws Exception {
        //First we make the odd lines, that is, the ones where the beeper should be at the beginning
        //After that, we move to the beginning of the even lines, those where there should not be a beeper at the beginning.
        makeOddRows();
        goToStartOfEvenRows();
        //leftIsClear() for one line
        //noBeepersPresent() for two lines
        if (leftIsClear() || noBeepersPresent()) {
            makeEvenRows();
        }
    }

    /**
     * Prerequisite: Karel stands at the beginning of the first odd line, looking east
     * Result: All odd lines are built, Karel stands in the northeast corner, looking north
     */
    private void makeOddRows() throws Exception {
        //Make a line, turn around looking north
        //If there is no wall, go forward
        //Check again if there is no wall, if not - go forward, turn right
        // and run this function again
        makeRow();
        goBack();
        carefulStepForward();
        if (frontIsClear()) {
            move();
            turnRight();
            makeOddRows();
        }
    }


    /**
     * Prerequisites: Karel is standing at the beginning of the line, where the beepers begin. He is looking east.
     * Result: The line is complete, Karel is standing at the end of the line, looking east.
     */
    private void makeRow() throws Exception {
        //This method is used only when Karel is standing where the beeper should be
        //We put the beeper, checking the wall in front of us, we move forward
        //We check the wall again, if not, we run this function again
        putBeeper();
        carefulStepForward();
        if (frontIsClear()) {
            move();
            makeRow();
        }
    }

    /**
     * Prerequisites: Karel stands at the end of the last odd, facing east
     * Result: Karel stands at the beginning of the first even, facing east
     */
    private void goToStartOfEvenRows() throws Exception {
        //Here, after we have made the odd lines, we go to the beginning of the even ones
        //and turn right.
        //It is also important to use careful movement, in case there is only one line on the map
        turnAround();
        moveToTheWall();
        turnAround();
        carefulStepForward();
        turnRight();
    }

    /**
     * Prerequisites: Karel stands at the beginning of the first even line, that is, on the second, looking east.
     * Result: All even lines are complete, Karel stands at the end of the last one, looking east.
     */
    private void makeEvenRows() throws Exception {
        //This is almost the same as with the makeOddRows function. But the difference is that
        //we can no longer simply use makeRow(). Here, each time you need to
        //step forward, this is a different method used here, so this method is different
        makeEvenRow();
        goBack();
        carefulStepForward();
        if (frontIsClear()) {
            move();
            turnRight();
            makeEvenRows();
        }
    }

    /**
     * Precondition: Karel is standing at the beginning of the even line, i.e. there should be no beepers in the first cell. Looking east
     * Result: Karel is standing at the end of the even line, looking east
     */
    private void makeEvenRow() throws Exception {
        //Same as makeRow, but moving forward
        if (frontIsClear()) {
            move();
            makeRow();
        }
    }

    /**
     * Prerequisites: Karel is standing at the end of a completed row (any row), facing east.
     * Result: Karel has returned to the beginning of the row, facing north
     */
    private void goBack() throws Exception {
        turnAround();
        moveToTheWall();
        turnRight();
    }

    /**
     * Prerequisites: Karel is standing at the beginning of a completed row. Looking north
     * Result: Karel has taken two steps forward, checking for a wall ahead. Looking north.
     */
    private void carefulStepForward() throws Exception {
        if (frontIsClear()) {
            move();
        }
    }
}
