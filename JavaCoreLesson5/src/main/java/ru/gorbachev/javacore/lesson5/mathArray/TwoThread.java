package ru.gorbachev.javacore.lesson5.mathArray;

import ru.gorbachev.javacore.lesson5.essence.OneArray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThread {

    private float[] arr;
    private int size;
    private int h;
    private List<Long> timeWork = new ArrayList<Long>();
    private float[] a1;
    private float[] a2;


    public TwoThread() {
        OneArray oneArray = new OneArray();
        this.arr = oneArray.getArr();
        this.size = oneArray.getSize();
        this.h = oneArray.getH();

        doIt();
    }

    //Математические операции над переданным массивом
    private synchronized void mathArray(float[] arr, boolean mark) {
        //Начинаем считать время и запускаем поток
        if (mark) {
            long a = System.currentTimeMillis();
            for (int i = 0; i < this.h; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            this.timeWork.add(System.currentTimeMillis() - a);
            this.a1 = arr;
        } else {
            long a = System.currentTimeMillis();
            for (int i = 0; i < this.h; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            this.timeWork.add(System.currentTimeMillis() - a);
            this.a2 = arr;
        }
    }

    //Разбиваем массивы
    private float[][] separationArray() {
        float[] a1 = new float[this.h];
        float[] a2 = new float[this.h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        this.timeWork.add(System.currentTimeMillis() - a);
        float[][] result = new float[2][this.h];
        result[0] = a1;
        result[1] = a2;

        return result;
    }

    private void doIt() {
        //Делим массив на два
        float[][] separationArray = this.separationArray();

        //Запускаем потоки
        new Thread(() -> mathArray(separationArray[0], true)).start();
        new Thread(() -> mathArray(separationArray[1], false)).start();

        //Ждем завершени потоков.
        for (;;){
            try {
                Thread.sleep(1000);
                //Если потоки завершилимь считаем общее время
                if (this.a1 != null && this.a2 != null){
                    this.arr = null;
                    this.arr = new float[this.size];
                    long a = System.currentTimeMillis();
                    System.arraycopy(a1, 0, this.arr, 0, h);
                    System.arraycopy(a2, 0, this.arr, h, h);
                    this.timeWork.add(System.currentTimeMillis() - a);
                    long allTime = 0;
                    for (Long time : this.timeWork) {
                        allTime += time;
                    }
                    System.out.println("Время выполнения в двух потоках равно " + allTime + " мс");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
