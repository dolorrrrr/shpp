package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part5 extends WindowProgram {

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 8;
    private static final int NUM_COLS = 8;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    public void run(){
        //Визначаємо довжину і ширину всього набору фігур
        double boxesWidth = (NUM_COLS * BOX_SIZE) + ((NUM_COLS - 1) * BOX_SPACING);
        double boxesHeight = (NUM_ROWS * BOX_SIZE) + ((NUM_ROWS - 1) * BOX_SPACING);

        double coordinateX = (getWidth() / 2.0) - (boxesWidth / 2.0);
        double coordinateY = (getHeight() / 2.0) - (boxesHeight / 2.0);



        for(int i = 0; i < NUM_COLS; i++){
            drawCellColumn(coordinateX, coordinateY);
            coordinateY = (getHeight() / 2.0) - (boxesHeight / 2.0);
            coordinateX += BOX_SIZE + BOX_SPACING;
        }
    }

    private void drawCellColumn(double coordinateX, double coordinateY){
        for (int j = 0; j < NUM_ROWS; j++) {
            createCell(coordinateX, coordinateY);
            coordinateY += BOX_SIZE + BOX_SPACING;
        }
    }

    private void createCell(double coordinateX, double coordinateY){
        GRect cell = new GRect(coordinateX, coordinateY, BOX_SIZE, BOX_SIZE);
        cell.setFilled(true);
        add(cell);
    }
}
