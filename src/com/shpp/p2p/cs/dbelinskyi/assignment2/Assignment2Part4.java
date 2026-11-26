package com.shpp.p2p.cs.dbelinskyi.assignment2;

import acm.graphics.GLabel;
import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GRect;

import java.awt.*;

public class Assignment2Part4 extends WindowProgram {

    //Визначають ширину та висоту вікна
    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 600;

    //Визначають ширину та висоту прапору
    private static final double FLAG_WIDTH = 500;
    private static final double FLAG_HEIGHT = 350;

    //Визначає кількість кольорів
    private static final double NUMBER_OF_COLORS = 3;

    //Визначає шрифт і розмір надпису
    private static final String FONT = "Roboto-35";

    //Константи кольорів, які будуть використовуватись в прапорі
    private static final Color FIRST_COLOR = new Color(0, 255, 247);
    private static final Color SECOND_COLOR = new Color(36, 145, 142);
    private static final Color THIRD_COLOR = new Color(65, 128, 126);

    //Визначає назву країни, якою буде підписаний прапор в формі (Flag of ...)
    private static final String COUNTRY = "Nothing";

    /**
     * Задача 4 - Прапори
     * Потрібно створити відцентрований прапор, який складається з трьох вертикальних кольорів
     * Розміри прапору регулюються константами
     * Окрім цього треба створити підпис, що це за прапор (Flag of ...)
     * Спочатку створюємо прапор:
     *  1. Створюємо відцентрований flagBackground, це треба, щоб відцентрувати весь прапор
     *  2. Створюємо вже самі кольори, які прив'язані саме до flagBackground.
     * Після цього створюємо підпис, тут єдина складність це правильно його розташувати.
     * Розташування підпису вже залежить від розмірів вікна. Тоді спочатку створюю просто напис, після цього
     * вже задаємо йому розташування методом setLocation() який має GLabel.
     */
    public void run() {
        createFlag();
        createNameOfCountry();
    }

    /**
     * Створює відцентрований зафарбований прапор
     * Передумова: нічого
     * Результат: Створено прапор, який розташовано в центрі вікна
     */
    private void createFlag() {
        //Визначення координат для прапору, щоб він розташувався в центрі екрану
        //Від половини ширини/висоти екрану віднімаємо половину ширини/висоти прапору
        double flagCoordinateX = (getWidth() / 2.0) - (FLAG_WIDTH / 2.0);
        double flagCoordinateY = (getHeight() / 2.0) - (FLAG_HEIGHT / 2.0);

        //Створення форми прапору, потрібна, щоб правильно розташовувати в ній зафарбовані частини
        GRect flagBackground = new GRect(flagCoordinateX, flagCoordinateY, FLAG_WIDTH, FLAG_HEIGHT);
        add(flagBackground);

        //Виконуємо метод makePartOfFlag стільки ж разів, скільки кольорів в прапорі (хоч в умові чітко вказано тільки
        // три кольори, я зробив так, щоб кількість була регульованою)
        for (int i = 0; i < NUMBER_OF_COLORS; i++) {
            makePartOfFlag(i, flagBackground);
        }

        add(flagBackground); //З рамкою мені здається буде краще. Та і на випадок, якщо один із кольорів - білий
    }

    /**
     * Створення підпису прапору, який розташований знизу справа вікна
     * Передумова: нічого
     * Результат: Створено підпис прапору, який розташовано в нижній правій частині екрану
     */
    private void createNameOfCountry() {
        //Спочатку просто створюємо надпис і його шрифт і тільки після цього задаємо його розташування
        GLabel nameOfCountry = new GLabel("Flag of " + COUNTRY);
        nameOfCountry.setFont(FONT);
        //Координата Х = ширина вікна - ширина надпису
        //Координата Y = висота вікна - НИЖНЯ ширина надпису
        nameOfCountry.setLocation(getWidth() - nameOfCountry.getWidth(), getHeight() - nameOfCountry.getDescent());
        add(nameOfCountry);
    }

    /**
     * Створює готову одну з частин прапора,
     * Передумова: на вхід подано номер частини прапору типу int, а також раніше створену форму прапора типу GRect
     * Результат: Створено готову зафарбовану частину прапора
     *
     * @param numberOfPart Номер частини прапору, яка створюється. Тип int
     * @param flag Форма прапора, потрібна для правильного розташування всіх частин
     */
    private void makePartOfFlag(int numberOfPart, GRect flag) {
        //Визначаємо ширину частини прапору і координату Х для кожної частини прапора, адже вона кожного разу різна
        double widthOfFlagPart = FLAG_WIDTH / NUMBER_OF_COLORS;
        double coordinateXForFlagPart = flag.getX() + (widthOfFlagPart * numberOfPart);

        // Створення частини прапора
        GRect flagPart = new GRect(coordinateXForFlagPart, flag.getY(), widthOfFlagPart, FLAG_HEIGHT);
        flagPart.setFilled(true);
        setColorOfFlagPart(numberOfPart, flagPart); //Так, як кольори також різні, залежно від номера прапора, цей метод окремо зафарбовує частину прапора

        add(flagPart);
    }

    /**
     * Визначає колір, яким має бути зафарбована частина прапора
     * Передумова: На вхід подано номер частини типу int, і створену фігуру частини прапора
     * Результат: Частина прапора зафарбована необхідними кольорами
     *
     * @param numberOfPart Номер частини прапора типу int, нумерація від нуля
     * @param flagPart Форма частини прапора типу GRect
     */
    private void setColorOfFlagPart(int numberOfPart, GRect flagPart) {
        //Нумерація від 0, залежно від частини прапору обирається потрібний колір
        switch (numberOfPart) {
            case (0):
                flagPart.setColor(FIRST_COLOR);
                flagPart.setFillColor(FIRST_COLOR);
                break;
            case (1):
                flagPart.setColor(SECOND_COLOR);
                flagPart.setFillColor(SECOND_COLOR);
                break;
            case (2):
                flagPart.setColor(THIRD_COLOR);
                flagPart.setFillColor(THIRD_COLOR);
                break;
        }
    }
}
