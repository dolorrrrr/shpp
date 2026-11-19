package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GCanvas;
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment2Part2 extends WindowProgram{

    private static final int APPLICATION_WIDTH = 1100;
    private static final int APPLICATION_HEIGHT = 1100;

    public void run(){
        //double radius = (getSmallerSide() / 3) / 2;
//        GOval ring1 = new GOval(0, 0, 600, 600);// тут відбувається якась невідома хуйня, треба розбиратись
//        add(ring1);

        GCanvas canvas = new GCanvas();
        canvas.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        add(canvas);
    }
    private double getSmallerSide() {
        double windowWidth = getWidth();
        double windowHeight = getHeight();

        if (windowHeight > windowWidth){
            return windowHeight;
        } else {
            return windowWidth;
        }
    }
}
