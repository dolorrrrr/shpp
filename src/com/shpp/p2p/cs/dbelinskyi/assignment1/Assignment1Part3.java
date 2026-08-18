package com.shpp.p2p.cs.dbelinskyi.assignment1;

import com.shpp.p2p.cs.dbelinskyi.SuperKarel;

public class Assignment1Part3 extends SuperKarel {
    /**
     * Задача 3 - Шахова дошка
     * ПРЯМОКУТНИК - ЦЕ НЕ ТІЛЬКИ КВАДРАТ
     * Один з поставлених біперів має знаходитись в південно-західному куті карти
     * Карел стартує з південно-західного кута, дивиться на схід
     * Довжина або ширина може бути 1
     * Не обов'язково вигадувати якусь круту "оптімізейшн"
     * Основна задача - це розмістити біпери так, як
     * розташовані чорні клітинки на шахівниці
     */
    public void run() throws Exception {
        makeOddRows();
        goToStartOfEvenRows();
        //На випадок одного рядку
        if(leftIsClear()) {
            makeEvenRows();
        }
    }

    /**
     * Передумова: Карел стоїть на початку першої непарної лінії, дивиться на схід
     * Результат: Всі непарні лінії побудовано, Карел стоїть в північно-східному куті, дивиться на північ
     */
    private void makeOddRows() throws Exception {
        makeRow();
        goBack();
        carefulStepForward();
        if (frontIsClear()) {
            move();
            turnRight();
            makeOddRows();
        }
    }


    /**
     * Передумови: Карел стоїть на початку рядка, де починаються біпери. Дивиться на схід.
     * Результат: Рядок закінчений, Карел стоїть в кінці рядка, дивлячись на схід.
     */
    private void makeRow() throws Exception {
        putBeeper();
        carefulStepForward();
        if (frontIsClear()) {
            move();
            makeRow();
        }
    }

    /**
     * Передумови: Карел стоїть в кінці останнього непарного, дивиться на схід
     * Результат: Карел стоїть на початку першого парного, дивиться на схід
     */
    private void goToStartOfEvenRows() throws Exception {
        turnAround();
        moveToTheWall();
        turnAround();
        carefulStepForward();
        turnRight();
    }

    /**
     * Передумови: Карел стоїть на початку першого парного рядка, тобто на другому, дивиться на схід.
     * Результат: Всі парні рядки закінчені, Карел стоїть в кінці останнього, дивлячись на схід.
     */
    private void makeEvenRows() throws Exception {
        makeEvenRow();
        goBack();
        carefulStepForward();
        if (frontIsClear()) {
            move();
            turnRight();
            makeEvenRows();
        }
    }

    /**
     * Передумова: Карел стоїть на початку парного рядка, тобто в першій клітинці не має бути біперів. Дивиться на схід
     * Результат: Карел стоїть на кінці парного рядка, дивиться на схід
     */
    private void makeEvenRow() throws Exception {
        if (frontIsClear()) {
            move();
            makeRow();
        }
    }

    /**
     * Передумови: Карел стоїть в кінці закінченого рядка (будь якого), дивиться на схід.
     * Результат: Карел повернувся в початок ряду, дивиться на північ
     */
    private void goBack() throws Exception {
        turnAround();
        moveToTheWall();
        turnRight();
    }

    /**
     * Передумови: Карел стоїть на початку закінченого ряду. Дивиться на північ
     * Результат: Карел пройшов два кроки вперед, перевіряючи, чи немає стіни попереду. Дивиться на північ.
     */
    private void carefulStepForward() throws Exception {
        if (frontIsClear()) {
            move();
        }
    }
}
