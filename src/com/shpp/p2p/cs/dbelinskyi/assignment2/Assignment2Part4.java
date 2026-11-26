package com.shpp.p2p.cs.dbelinskyi.assignment2;

import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GRect;

import java.awt.*;

public class Assignment2Part4 extends WindowProgram {

    static final double FLAG_WIDTH = 500;
    static final double FLAG_HEIGHT = 50;

    public void run() {

        double flagCoordinateX = (getWidth() / 2) - FLAG_WIDTH / 2;
        double flagCoordinateY = (getHeight() / 2) - FLAG_HEIGHT / 2;

        GRect rect = new GRect(flagCoordinateX, flagCoordinateY, FLAG_WIDTH, FLAG_HEIGHT);
        rect.setFilled(true);
        rect.setColor(Color.YELLOW);
        rect.setFillColor(Color.CYAN);
        add(rect);

    }
}
