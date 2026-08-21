package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GLabel;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment1Part1 extends WindowProgram {
    public void run() {
        GLabel l;
        l = new GLabel("hello world", 100, 200);
        l.setFont("Verdana-50");
        l.setColor(Color.CYAN);
        this.add(l);

        add(l);
    }
}
