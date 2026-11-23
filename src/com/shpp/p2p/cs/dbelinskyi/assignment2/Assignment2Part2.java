package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part2 extends WindowProgram{

    // Константи для регулювання розміру вікна
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 800;

    //Константа для регулювання розміру кульки
    public static final int DIAMETER = 300;

    /**
     * Задача 2 - Ілюзорні контури.
     * Створити білий прямокутник, що накладається на чотири кола, які розташовано в кутах вікна.
     * Треба скористуватись константами для легкого регулюваня розміру кіл, або обчислити його розмір, спираючись на
     * розмір вікна.
     * Рішення:
     * 1. Створюємо чотири чорних кола
     * 2. Створюємо квадрат з кутами в центрах кіл
     */
    public void run(){
        createCircles();
        createWhiteRectangle();
    }

    /**
     * Створює чотири кола в кутах вікна
     * Передумова: немає, маємо лише константу діамерту та розміри вікна
     * Результат: створено чотири кола в кутах вікна з потрібним діаметром.
     */
    private void createCircles(){
        createFilledCircle(0, 0, DIAMETER, DIAMETER); // Верхнє ліве коло
        createFilledCircle(getWidth() - DIAMETER, 0, DIAMETER, DIAMETER); // Верхнє праве коло
        createFilledCircle(0, getHeight() - DIAMETER, DIAMETER, DIAMETER); // Нижнє ліве коло
        createFilledCircle(getWidth() - DIAMETER, getHeight() - DIAMETER, DIAMETER, DIAMETER); // Нижнє праве коло
    }

    /**
     * Створює білий прямокутник, кожен його кут розташовано в центрах кіл
     * Передумова: створено чотири кола в кутах вікна
     * Результат: Створено білий прямокутник, який накладається на створені кола
     */
    private void createWhiteRectangle(){
        double radius = DIAMETER / 2.0; //радіус це половина діаметру

        GRect whiteRectangle = new GRect(radius, radius, getWidth() - DIAMETER, getHeight() - DIAMETER);

        whiteRectangle.setColor(Color.WHITE); // Для того, щоб грані теж були білими
        whiteRectangle.setFillColor(Color.WHITE);
        whiteRectangle.setFilled(true);

        add(whiteRectangle);
    }

    /**
     * Створює одне замальоване чорне коло
     * Передумова: На вхід подається розташування кола по осям х та у. Також його висота та ширина
     * Результат: Створено одне чорне замальоване коло за заданими параметрами
     */
    private void createFilledCircle(double x, double y, double w, double h){
        GOval circle  = new GOval(x , y, w, h);
        circle.setFilled(true);
        add(circle);
    }

}
