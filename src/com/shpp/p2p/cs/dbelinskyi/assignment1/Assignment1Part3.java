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
        //makeVerticalLine();
        makeOddRows();
        goToStartOfEvenRows();
        makeEvenRows();
    }

    private void makeVerticalLine() throws Exception {

    }

    private void makeOddRows() throws Exception{
        makeOddRow();
        goBack();
        carefulStepForward();
        if (frontIsClear()){
            move();
            turnRight();
            makeOddRows();
        }
    }


    /**
     * Передумови: Карел стоїть на початку непарного рядка, Дивиться на схід.
     * Результат: Непарний рядок закінчені, Карел стоїть в кінці рядка, дивлячись на схід.
     */
    private void makeOddRow() throws Exception {
        putBeeper();
        carefulStepForward();
        carefulStepForward();
        if (frontIsClear()){
            makeOddRow();
        }//тут є проблема, якщо ширина непарна, то останній біпер він не кладе
    }

    /**
     * Передумови: Карел стоїть в кінці останнього непарного, дивиться на схід
     * Результат: Карел стоїть на початку першого парного, дивиться на схід
     */
    private void goToStartOfEvenRows() throws Exception {

    }

    /**
     * Передумови: Карел стоїть на початку першого парного рядка, тобто на другому, дивиться на схід.
     * Результат: Всі парні рядки закінчені, Карел стоїть в кінці останнього, дивлячись на схід.
     */
    private void makeEvenRows() throws Exception {


    }

    /**
     * Передумови: Карел стоїть на початку непарного ряду. Дивиться на схід.
     * Результат: Ряд закінчений, Карел стоїть в кінці непарного ряду, дивиться на схід.
     */
    private void fillOddLine() throws Exception {
        while (frontIsClear()) {
            putBeeper();
            move();
            if (frontIsClear()) {
                move();
            }
        }
    }

    private void fillEvenLine() {
    }

    /**
     * Передумови: Карел стоїть в кінці закінченого рядку (будь якого), дивиться на схід.
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
