package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class DrawChessboard extends WindowProgram {

    private static final int ITEM_SIZE = 40;
    private static final int CIRCLES_COUNT_IN_COL = 8;
    private static final int CIRCLES_COUNT_IN_ROW = 8;

    public void run() {
        drawCheckerBoard(CIRCLES_COUNT_IN_COL, CIRCLES_COUNT_IN_ROW);
    }

    /**
     * Передумова: Пустий білий канвас, нічого немає на ньому
     * Результат: Намальована шахівниця, розмір задається аргументами (рядки, стовпці)
     */
    private void drawCheckerBoard(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            drawCheckerBoardRow(i, cols);
        }
    }

    /**
     * Передумова: Початок ітерації. Треба намалювати один ряд
     * Результат: Ряд намальований
     */
    private void drawCheckerBoardRow(int rowNumber, int cols) {
        for (int i = 0; i < cols; i++) {
            drawCheckBoardItem(rowNumber, i);
        }
    }

    /**
     *Малює один єдиний елемент - клітинку протягом циклу
     * Може бути як чорним, так і білим
     */
    private void drawCheckBoardItem(int rowNumber, int colNumber) {
        GRect r = new GRect(colNumber * ITEM_SIZE, rowNumber * ITEM_SIZE, ITEM_SIZE, ITEM_SIZE);
        r.setFilled(true);
        setFillWhiteOrBlack(rowNumber, colNumber, r);
        r.setColor(Color.RED);
        add(r);
    }

    /**
     * Обирає потрібний колір під час малювання, базуючись на сумі індексів клітинок.
     * Якщо сума парна - клітинка має бути чорною
     * Нічого не повертає, просто обирає потрібний колір
     */
    private void setFillWhiteOrBlack(int rowNumber, int colNumber, GRect rectangle) {
        boolean isCellBlack = (rowNumber + colNumber) % 2 == 0;
        rectangle.setFillColor(isCellBlack ? Color.BLACK : Color.CYAN);
    }
}
