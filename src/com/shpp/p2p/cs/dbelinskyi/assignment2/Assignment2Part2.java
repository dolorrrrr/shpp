package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GCanvas;
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part2 extends WindowProgram{

    private static final int APPLICATION_WIDTH = 1100;
    private static final int APPLICATION_HEIGHT = 1100;

    public void run(){
        double diameter = getSmallerSide() / 3;

        GOval r1 = new GOval(0, 0, diameter, diameter);
        r1.setFilled(true);
        add(r1);
        GOval r2 = new GOval(getWidth() - diameter, 0, diameter, diameter);
        r2.setFilled(true);
        add(r2);
        GOval r3 = new GOval(0, getHeight() - diameter, diameter, diameter);
        r3.setFilled(true);
        add(r3);
        GOval r4 = new GOval(getWidth() - diameter, getHeight() - diameter, diameter, diameter);
        r4.setFilled(true);
        add(r4);
        double radius = diameter / 2;
        GRect rect = new GRect(radius, radius, getWidth() - diameter, getHeight() - diameter);
        rect.setColor(Color.WHITE);
        rect.setFillColor(Color.WHITE);
        rect.setFilled(true);
        add(rect);

    }

    private double getSmallerSide(){
        if(getWidth() < getHeight()){
            return getWidth();
        } else {
            return getHeight();
        }
    }
}
