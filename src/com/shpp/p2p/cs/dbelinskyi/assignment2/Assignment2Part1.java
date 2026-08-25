package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.*;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part1 extends WindowProgram {

    public void run() {
        int r = 50;
        int d = r * 2;
        int x = getWidth() / 2 - r;
        int y = getHeight() / 2 - (d * 3 / 2);
        GOval c1 = createCircle(Color.RED, x, y, r);
        add(c1);
        GRectangle boundsOfKolo1 = c1.getBounds();
        add(createCircle(Color.YELLOW, boundsOfKolo1.getX(), boundsOfKolo1.getY() + (r * 2), r));
        add(createCircle(Color.GREEN, x, y + (r * 2) + (r * 2), r));
    }

    private GOval createCircle(Color color, double x, double y, double r) {
        GOval res = new GOval(x, y, r * 2, r * 2);
        fillObject(res, color);
        return res;
    }

    private void fillObject(GFillable obj, Color color) {
        obj.setFillColor(color);
        obj.setFilled(true);
    }
}
