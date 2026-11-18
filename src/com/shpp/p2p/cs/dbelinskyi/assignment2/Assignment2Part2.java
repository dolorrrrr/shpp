package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment2Part2 extends WindowProgram{

    private static final int APPLICATION_WIDTH = 300;
    private static final int APPLICATION_HEIGHT = 300;

    public void run(){
        GOval oval1 = new GOval( 0,0,50, 50);
        oval1.setFilled(true);
        add(oval1);
    }
}
