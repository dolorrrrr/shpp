package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.*;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class MyGraphicsProgram extends WindowProgram{
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
