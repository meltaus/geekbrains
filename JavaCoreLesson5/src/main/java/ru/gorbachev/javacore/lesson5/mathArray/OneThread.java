package ru.gorbachev.javacore.lesson5.mathArray;

import ru.gorbachev.javacore.lesson5.essence.OneArray;

public class OneThread implements Runnable {

    private float[] arr;
    private int size;

    public OneThread() {
        OneArray oneArray = new OneArray();
        this.arr = oneArray.getArr();
        this.size = oneArray.getSize();
    }

    public void run() {
        //Начинаем отсчет времени
        long a = System.currentTimeMillis();
        for (int i = 0; i < this.size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения в одном потоке " + (System.currentTimeMillis() - a) + " мс");
    }
}
