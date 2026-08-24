package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class DrawChessboard extends WindowProgram {

    private static final int ITEM_SIZE = 40;
    private static final int CIRCLES_COUNT_IN_COL = 8;
    private static final int CIRCLES_COUNT_IN_ROW = 8;

    public void run() {
        drawCheckerBoard(CIRCLES_COUNT_IN_COL, CIRCLES_COUNT_IN_ROW);
    }

    private void drawCheckerBoard(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            drawCheckerBoardRow(i, cols);
            //blackOrNot = reverseColor(blackOrNot);

        }
    }


    private void drawCheckerBoardRow(int rowNumber, int cols) {
        for (int i = 0; i < cols; i++) {
            drawCheckBoardItem(rowNumber, i);
        }
    }

    private void drawCheckBoardItem(int rowNumber, int colNumber) {
        GRect r = new GRect(
                colNumber * ITEM_SIZE,
                rowNumber * ITEM_SIZE,
                ITEM_SIZE, ITEM_SIZE);
        r.setFilled(true);
        boolean isCellBlack = (rowNumber + colNumber) % 2 == 0;
        r.setFillColor(isCellBlack ? Color.BLACK : Color.CYAN);
        r.setColor(Color.RED);
        add(r);
    }
}
