package com.shpp.p2p.cs.dbelinskyi.assignment2;

import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GRect;

import java.awt.*;

public class Assignment2Part4 extends WindowProgram {

    static final double FLAG_WIDTH = 500;
    static final double FLAG_HEIGHT = 50;

    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 600;

    public void run() {

        double flagCoordinateX = (getWidth() / 2.0) - (FLAG_WIDTH / 2.0);
        double flagCoordinateY = (getHeight() / 2.0) - (FLAG_HEIGHT / 2.0);

        GRect rect = new GRect(flagCoordinateX, flagCoordinateY, FLAG_WIDTH, FLAG_HEIGHT);
        rect.setFilled(true);
        rect.setColor(Color.YELLOW);
        rect.setFillColor(Color.CYAN);
        add(rect);

    }
}
