package gorbachev.javacore.lesson2;

import gorbachev.javacore.lesson2.essence.TransformationArray;

public class Lesson2 {

    public static void main(String[] args) {

        //Создаем строковый массив с произвольным содержимым
        TransformationArray transformationArray = new TransformationArray(createArray(4));

        System.out.println(transformationArray.toString());
    }


    //Создаем строковый массив размерности m*m и заполняем случайными данными, которые можно приести к int
    private static String[][] createArray(int size) {
        String array[][] = new String[size][size];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = Integer.toString(0 + (int)(Math.random() * ((1000 - 0) + 1)));
            }
        }

        return array;
    }
}
