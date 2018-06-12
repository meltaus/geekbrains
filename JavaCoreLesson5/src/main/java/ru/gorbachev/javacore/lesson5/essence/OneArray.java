package ru.gorbachev.javacore.lesson5.essence;

public class OneArray {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public OneArray() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    public static int getSize() {
        return size;
    }

    public static int getH() {
        return h;
    }

    public float[] getArr() {
        return arr;
    }
}
