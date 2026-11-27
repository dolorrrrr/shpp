package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part5 extends WindowProgram {

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    public void run(){
        //Визначаємо довжину і ширину всього набору фігур
        double resultWidth = (NUM_COLS * BOX_SIZE) + ((NUM_COLS - 1) * BOX_SPACING);
        double resultHeight = (NUM_ROWS * BOX_SIZE) + ((NUM_ROWS - 1) * BOX_SPACING);

        double coordinateX = (getWidth() / 2.0) - (resultWidth / 2.0);
        double coordinateY = (getHeight() / 2.0) - (resultHeight / 2.0);

        for (int i = 0; i < NUM_COLS; i++){
            for (int j = 0; j < NUM_ROWS; j++){
                createCell(coordinateX, coordinateY);
                coordinateX += (BOX_SIZE + BOX_SPACING);
            }
        }
    }

    private void createCell(double coordinateX, double coordinateY){
        GRect cell = new GRect(coordinateX, coordinateY, BOX_SIZE, BOX_SIZE);
        cell.setFilled(true);
        add(cell);
    }
}
