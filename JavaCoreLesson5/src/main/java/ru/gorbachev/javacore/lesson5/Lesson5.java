package ru.gorbachev.javacore.lesson5;

import ru.gorbachev.javacore.lesson5.mathArray.OneThread;
import ru.gorbachev.javacore.lesson5.mathArray.TwoThread;

public class Lesson5 {

    public static void main(String args[]) {
        Thread oneThread = new Thread(new OneThread());
        oneThread.start();

        TwoThread twoThread = new TwoThread();
    }
}
