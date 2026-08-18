package com.shpp.p2p.cs.dbelinskyi.assignment1;

import com.shpp.p2p.cs.dbelinskyi.SuperKarel;

/**
 * Задача 4 - Ядерний реактор
 * Основна задача - очистити елементи де немає центрального біпера
 * Елемент реактора - вертикальна лінія, де немає стін
 * Тобто якщо в центрі вертикального ряду немає біпера - очистка повністю,
 *  якщо є - пропускаємо
 * Світ складається з послідовності вертикальних рядів - елементів і
 *  розмежовувачів - рядів зі стінами. Кількість елементів може бути різною
 * Кожен елемент - 1 ширина і 3 висота
 * Карел знаходиться в самому початку реактора і дивиться на схід, в бік коридору
 * Після закінчення роботи Карел має знаходитись в кінці коридору
 */
public class Assignment1Part4 extends SuperKarel {
    public void run() throws Exception{
        cleanTheReactor();
    }

    private void cleanTheReactor() throws Exception{
        if(noBeepersPresent()){
            cleanElement();
        }
        move();
        move();
        if (frontIsClear()){
            cleanTheReactor();
        }
    }

    private void cleanElement() throws Exception{
        turnLeft();
        move();
        turnAround();
        moveWithCleaning();
        turnAround();
        move();
        turnRight();
    }

    private void moveWithCleaning() throws Exception{
        pickAllBeepers();
        if(frontIsClear()){
            move();
            moveWithCleaning();
        }

    }

    private void pickAllBeepers() throws Exception{
        while (beepersPresent()){
            pickBeeper();
        }
    }
}
