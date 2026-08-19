package com.shpp.p2p.cs.dbelinskyi.assignment1;

import com.shpp.p2p.cs.dbelinskyi.SuperKarel;

/**
 * Problem 2 - finding the middle
 * Final view of the level - 1 beeper in the middle of the south strip
 * If the length of the strip is even - in one of the middles
 * Karel starts in the southwest corner and looks east
 * There are a lot of beepers
 * All beepers must be selected, except for one in the middle of the south strip
 * There are no walls or beepers in the world
 * It may not be square
 * The world is as tall as it is wide, i.e. height > width.
 * It makes no sense where Karel is looking at the end of the level
 */
public class Assignment1Part2 extends SuperKarel {
    public void run() throws Exception {
        if (frontIsBlocked()) //A non-standard case when the world is 1x1
        {
            putBeeper();
        } else //For all other cases it works correctly
        {
            /**
             * The algorithm is as follows: we fill the southern row, collect all the beepers in one pile - this way we found out
             * the length of the line. We use this cell as a variable. We divide it in half, as the main one we use
             * the larger one (if the length is odd). Then we arrange this pile of beepers along the line, the last beeper should be
             * the central one. After that we remove all the other beepers. The only option when this algorithm does not work is
             * when the length of the southern line is 1. Therefore, we also check for this and for this option we simply put 1 beeper
             */
            fillTheLine();
            removeAllBeepersAtTheOneCell();
            divideACell();
            removeDividedCellToStartCell();
            cleanUnnecessaryCell();
            goToFatherCell();
            fillTheLineFromFatherCell();
            cleanUnnecessaryBeepers();
        }
    }

    /**
     * Prerequisite: Karel is facing east, preparing to fill the line with beepers
     * Result: Karel is facing east, standing at the end of the line, i.e. in the southeast corner
     */
    private void fillTheLine() throws Exception {
        while (frontIsClear()) {
            putBeeper();
            move();
        }
        putBeeper();
    }

    /**
     * Prerequisite: Karel is facing east, at the end of the main line.
     * Result: All beepers are moved to one cell, Karel is standing on this cell and facing north
     */
    private void removeAllBeepersAtTheOneCell() throws Exception {
        turnAround();
        while (frontIsClear()) {
            if (beepersPresent()) {
                takeBeeperAndTakeItToCell();
                turnAround();
                move();
                turnRight();
            }
            move();
        }
        takeBeeperAndTakeItToCell();
    }

    /**
     * Prerequisite: Karel is standing on the beeper, looking west
     * Result: Karel has taken the beeper to the right place, looking north
     */
    private void takeBeeperAndTakeItToCell() throws Exception {
        pickBeeper();
        turnAround();
        moveToTheWall();
        turnLeft();
        move();
        putBeeper();
    }

    /**
     * Prerequisite: Karel is standing on the cell with beepers to be divided, looking north
     * Result: Karel is standing in the same place he was at the beginning of the method.
     * The cell is divided - the parent cell is in front of him, the residual cell is
     * on the right side. Karel is looking south
     */
    private void divideACell() throws Exception {
        turnAround();
        while (beepersPresent()) {
            if (beepersPresent()) {
                moveBeeperToOneStepForwardAndBack();
            }
            turnRight();
            if (beepersPresent()) {
                moveBeeperToOneStepForwardAndBack();
            }
            turnLeft();
        }
    }

    /**
     * Prerequisite: Karel is standing on a beeper, there is no wall in front of him.
     * Result: Karel moved one beeper forward and turned around, looking where he was looking at first
     */
    private void moveBeeperToOneStepForwardAndBack() throws Exception {
        pickBeeper();
        move();
        putBeeper();
        stepBack();
    }

    /**
     * Prerequisite: There is no wall behind Karel
     * Result: Karel took a step back, looking back where he was looking at first
     */
    private void stepBack() throws Exception {
        turnAround();
        move();
        turnAround();
    }

    /**
     * Prerequisite: Karel is standing in front of a pile of beepers that needs to be moved to its place.Looks at them
     * Result: Karel has moved the entire pile of beepers to its place, looks where he was looking from the beginning
     */
    private void removeDividedCellToStartCell() throws Exception {
        move();
        turnAround();
        while (beepersPresent()) {
            moveBeeperToOneStepForwardAndBack();
        }
        move();
        turnAround();
    }

    /**
     * Prerequisite: Karel is standing on the main divided pile, facing south
     * Result: Karel has cleared the remaining divided pile, is standing on its spot, facing west
     */
    private void cleanUnnecessaryCell() throws Exception {
        turnRight();
        move();
        while (beepersPresent()) {
            pickBeeper();
        }
    }

    /**
     * Prerequisite: Karel is standing on the cleared cell, looking west
     * Result: Karel has come to the cell used as a variable. Looking west
     */
    private void goToFatherCell() throws Exception {
        turnAround();
        move();
        turnRight();
    }

    /**
     * Prerequisite: Karel stands on the main pile, facing south, preparing to fill the line until the beepers stop
     * Result: Karel has filled the main line halfway, returned to the place from which he started this method.
     */
    private void fillTheLineFromFatherCell() throws Exception {
        while (beepersPresent()) {
            removeOneBeeperAtLineFromCell();
            goBackToTheCell();
        }
    }

    /**
     * Prerequisite: Karel stands on the main pile of beepers, looking south.
     * Result: Karel took one beeper to the first unoccupied cell on the main line. Looking west
     */
    private void removeOneBeeperAtLineFromCell() throws Exception {
        pickBeeper();
        move();
        turnRight();
        while (beepersPresent()) {
            move();
        }
        putBeeper();
    }

    /**
     * Prerequisite: Karel stands on the main line, where he placed the beeper, looking west.
     * Result: Karel has returned to the main cluster of beepers, looking south.
     */
    private void goBackToTheCell() throws Exception {
        turnAround();
        moveToTheWall();
        turnLeft();
        move();
        turnAround();
    }

    /**
     * Prerequisite: Karel is standing in the place of the main pile, which has already been dismantled. Looking south
     * Result: Karel has removed all the beepers except the central one. Standing in the southeast corner, looking east. Program finale.
     */
    private void cleanUnnecessaryBeepers() throws Exception {
        goToTheCenter();
        pickAllBeepersInFront();
    }

    /**
     * Prerequisite: Karel is standing on the main disassembled pile, facing south.
     * Result: Karel is standing on the central beeper, facing east
     */
    private void goToTheCenter() throws Exception {
        move();
        turnRight();
        while (beepersPresent()) {
            move();
        }
        turnAround();
        move();
    }

    /**
     * Prerequisite: Karel is standing on the central beeper, facing east
     * Result: Karel has removed all the beepers except the central one on the line, that is, the ones that were in front of him.
     * He is in the southeast corner, facing east. Program Finale
     */
    private void pickAllBeepersInFront() throws Exception {
        while (frontIsClear()) {
            move();
            pickBeeper();
        }
    }
}