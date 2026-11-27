package com.shpp.p2p.cs.dbelinskyi.assignment2;

import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GOval;
import java.awt.*;

public class Assignment2Part6 extends WindowProgram{

    // Кількість сегментів (кілець) гусениці
    private static final int NUMBER_OF_SEGMENTS = 6;
    // Розмір сегменту (діаметер)
    private static final double SIZE_OF_SEGMENT = 200;

    private static final Color BOUNDS_OF_SEGMENT = new Color(13,142,100);
    private static final Color COLOR_OF_SEGMENT = new Color(255,0,123);

    /*
    Задача 6 - Гусениця
    За допомогою GOval треба створити гусеницю
    Овали мають накладатись один на одного в правильному порядку
    Відцентровувати, чи наприклад, займати весь простріп необов'язково
    Колір сегменту має відрізнятись від його країв.
    Також має бути реалізована можливість змінювати кількість сегментів (наприклад через константу)
    */
    public void run(){
        for(int i = 0; i < NUMBER_OF_SEGMENTS; i++) {
            drawSegment(100*i, 10);
        }

    }

    private void drawSegment(double coordinateX, double coordinateY){
        GOval segment = new GOval(coordinateX, coordinateY, SIZE_OF_SEGMENT,SIZE_OF_SEGMENT);
        segment.setFilled(true);
        segment.setColor(BOUNDS_OF_SEGMENT);
        segment.setFillColor(COLOR_OF_SEGMENT);
        add(segment);
    }
}
