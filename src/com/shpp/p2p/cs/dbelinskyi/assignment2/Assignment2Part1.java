package com.shpp.p2p.cs.dbelinskyi.assignment2;

import com.shpp.cs.a.console.TextProgram;

import static java.lang.Math.*;

public class Assignment2Part1 extends TextProgram {
    /*
    Маємо на вхід три числа - коефіцієнти квадратного рівняння
    Квадратне рівняння має вигляд a * (x^2) + b*x + c = 0
    Рішення:
    1. Отримуємо три числа користувача
    2. Знаходимо дискримінант, формула - b^2 - 4ac
    3. Розгалужуємо на три випадки:
    3.1 Дискримінант більше ніж 0 - два корені, формула -b +- sqrt(D) / 2a
    3.2 Дискримінант дорівнює нулю - один корінь, формула -b / 2a
    3.3 Дискримінант менше ніж нуль - коренів немає, формула sqrt(-1) / 0
    4. Виводимо результат
     */
    public void run() {
        double userNumberA = readDouble("Input number a: ");
        double userNumberB = readDouble("Input number b: ");
        double userNumberC = readDouble("Input number c: ");

        printAnswer(userNumberA, userNumberB, userNumberC);
    }

    /**
     * Знаходить дискримінант, вирішує рівняння, виводить результат
     * Передумова: на вхід подається три числа - коефіцієнти рівняння
     * Результат: рішення квадратного рівняння виведено в консоль
     */
    private void printAnswer(double numA, double numB, double numC) {
        double discriminant = getDiscriminant(numA, numB, numC);

        if (discriminant > 0) {
            double root1 = ((-numB) + sqrt(discriminant)) / (2 * numA);
            double root2 = ((-numB) - sqrt(discriminant)) / (2 * numA);
            println("There are two roots: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root1 = (-numB) / (2 * numA);
            println("There is one root: " + (root1));

        } else {
            println("There is no real roots");
        }

    }

    /**
     * Приймає три коефіцієнти квадратного рівняння і знаходить дискримінант.
     * Формула дискримінанта: b^2-4ac
     * Передумова: на вхід подається три числа - коефіцієнти квадратного рівняння
     * Результат: на вихід подає дискримінант
     */
    private double getDiscriminant(double numA, double numB, double numC) {
        return pow(numB, 2) - (4 * numA * numC);
    }
}

