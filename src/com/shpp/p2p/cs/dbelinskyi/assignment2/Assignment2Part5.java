package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

public class Assignment2Part5 extends WindowProgram {

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    public void run(){
        //Визначаємо довжину і висоту всієї матриці
        //Формула: кількість (колонок/рядків * розмір клітинки) + (кількість пропусків * довжину пропуску)
        double matrixWidth = (NUM_COLS * BOX_SIZE) + ((NUM_COLS - 1) * BOX_SPACING);
        double matrixHeight = (NUM_ROWS * BOX_SIZE) + ((NUM_ROWS - 1) * BOX_SPACING);

        drawCells(getStartCoordinateX(matrixWidth), getStartCoordinateY(matrixHeight), matrixHeight);
    }

    /**
     * Створює матрицю з квадратів
     * Передумова: визначено початкові координати для матриці, її загальну довжину і ширину
     * Результат: Створено відцентровану матрицю, програму закінчено
     *
     * @param coordinateX Початкова координата Х, тип double
     * @param coordinateY Початкова координата Y, тип double
     * @param matrixHeight Висота всієї матриці, потрібна для скидання координати Y. Tип double
     */
    private void drawCells(double coordinateX, double coordinateY, double matrixHeight){
        for(int i = 0; i < NUM_COLS; i++){
            drawCellColumn(coordinateX, coordinateY);
            coordinateY = getStartCoordinateY(matrixHeight); // координату Y треба скинути до початкового значення
            coordinateX += BOX_SIZE + BOX_SPACING; // перехід до наступної колонни по осі Х
        }
    }

    /**
     * Визначає початкову координату X для матриці
     * Формула: половина ширини екрану мінус половина ширини матриці
     * Передумова: на вхід подано ширину матриці типу double
     * Результат: на виході значення початкової координати X типу double
     *
     * @param matrixWidth Ширина матриці
     * @return Початкова координата Х типу double
     */
    private double getStartCoordinateX(double matrixWidth) {
        return (getWidth() / 2.0) - (matrixWidth / 2.0);
    }

    /**
     * Визначає початкову координату X для матриці
     * Формула: половина ширини екрану мінус половина ширини матриці
     * Передумова: на вхід подано ширину матриці
     * Результат: на виході значення початкової координати Х типу double
     *
     * @param matrixHeight Висота матриці
     * @return Початкова координата Y типу double
     */
    private double getStartCoordinateY(double matrixHeight) {
        return (getHeight() / 2.0) - (matrixHeight / 2.0);
    }

    /**
     * Створює одну колонну квадратів матриці
     * Передумова: на вхід подано координату Х та Y типу double, з яких має почати будуватись колонна
     * Результат: Створено одну колонну, після чого координату Y треба скидати до початкового значення
     *
     * @param coordinateX координата Х, з якої починається колонна
     * @param coordinateY координата Y, з якої починається колонна
     */
    private void drawCellColumn(double coordinateX, double coordinateY){
        for (int j = 0; j < NUM_ROWS; j++) {
            createCell(coordinateX, coordinateY);
            coordinateY += BOX_SIZE + BOX_SPACING;
        }
    }

    /**
     * Створює один замальований квадрат матриці
     * Передумова: на вхід подано координату X та Y типу double, за якими має бути розташований квадрат
     * Результат: Створено замальований квадрат матриці
     *
     * @param coordinateX координата Х, з якої починається клітинка
     * @param coordinateY координата Y, з якої починається клітинка
     */
    private void createCell(double coordinateX, double coordinateY){
        GRect cell = new GRect(coordinateX, coordinateY, BOX_SIZE, BOX_SIZE);
        cell.setFilled(true);
        add(cell);
    }
}


