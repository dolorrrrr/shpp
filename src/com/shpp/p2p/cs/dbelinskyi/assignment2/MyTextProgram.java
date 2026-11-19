package com.shpp.p2p.cs.dbelinskyi.assignment2;

import com.shpp.cs.a.console.TextProgram;

public class MyTextProgram extends TextProgram {

    public void run(){
        double numA = readDouble("Input number A:");
        double numB = readDouble("Input number B:");
        double numC = readDouble("Input number C:");

        getAnswerInConsole(numA, numB, numC);
    }

    private void getAnswerInConsole(double numA, double numB, double numC) {
        double discriminant = findDiscriminant(numA, numB, numC);

        if (discriminant < 0){
            println("There are no roots.");
        } else if (discriminant == 0) {
            double root = -numB / (2 * numA);
            println("There are 1 root: " + root);
        } else if  (discriminant > 0){
            double root1 = (-numB + Math.sqrt(discriminant))/ (2 * numA);
            double root2 = (-numB - Math.sqrt(discriminant))/ (2 * numA);
            println("There are 2 roots: " + root1 + " and " + root2);
        } else {
            println("Discriminant is not a number, or infinity.");
        }

    }

    private double findDiscriminant (double numA, double numB, double numC){
        return Math.pow(numB, 2) - (4 * numA * numC);

    }
}