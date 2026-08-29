package com.shpp.p2p.cs.dbelinskyi.assignment2;

import com.shpp.cs.a.console.TextProgram;

public class MyTextProgram extends TextProgram {

    private static final int STOP_NUMBER = 0;

    public void run() {
        for(double i = 0; i < 1; i += 0.1){
            println("sin "+i+" = " +Math.sin(i));
        }
    }
}
