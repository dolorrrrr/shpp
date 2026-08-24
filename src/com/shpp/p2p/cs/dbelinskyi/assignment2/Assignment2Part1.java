package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part1 extends WindowProgram {

    private static final int ITEM_SIZE= 40;
    private static final int CIRCLES_COUNT_IN_COL = 8;
    private static final int CIRCLES_COUNT_IN_ROW = 8;

    public void run() {
        drawCheckerBoard(CIRCLES_COUNT_IN_COL, CIRCLES_COUNT_IN_ROW);
    }

    private void drawCheckerBoard(int rows, int cols) {
        boolean blackOrNot = true;
        for (int i = 0; i < rows; i++){
            drawCheckerBoardRow(i, cols, blackOrNot);
            blackOrNot = reverseColor(blackOrNot);

        }
    }



    private void drawCheckerBoardRow(int rowNumber, int cols, boolean blackOrNot) {
        for (int i = 0; i < cols; i++){
            drawCheckBoardItem(rowNumber, i, blackOrNot);
            blackOrNot = reverseColor(blackOrNot);
        }
    }


    private boolean reverseColor(boolean blackOrNot) {
        if (blackOrNot){
            return blackOrNot = false;

        } else {
            return blackOrNot = true;
        }
    }


    private void drawCheckBoardItem(int rowNumber, int colNumber, boolean blackOrNot) {
        GRect r = new GRect(
                colNumber*ITEM_SIZE,
                rowNumber*ITEM_SIZE,
                ITEM_SIZE, ITEM_SIZE);
        r.setFilled(true);
        r.setFillColor(blackOrNot ? Color.BLACK : Color.WHITE);
        r.setColor(Color.BLACK);
        add(r);
    }
}
