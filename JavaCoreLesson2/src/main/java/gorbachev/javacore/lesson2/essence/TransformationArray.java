package gorbachev.javacore.lesson2.essence;

import gorbachev.javacore.lesson2.exeption.MyArrayDataException;
import gorbachev.javacore.lesson2.exeption.MySizeArrayException;

import java.util.Arrays;

public class TransformationArray {

    private int array[][];

    public TransformationArray() {
        System.out.println("Я не могу работать с пустотой");
    }

    public TransformationArray(String array[][]) {
        createArray(array);
    }

    private void createArray(String array[][]) {
        int size = array.length;
        try {
            if (size != 4) {
                throw new MySizeArrayException();
            } else {
                this.array = new int[4][4];
                for (int i = 0; i < size; i++) {
                    if (array[i].length == 4) {
                        for (int j = 0; j < 4; j++) {
                            try {
                                this.array[i][j] = Integer.parseInt(array[i][j]);
                            } catch (NumberFormatException ex) {
                                throw new MyArrayDataException(i, j);
                            }
                        }
                    }
                }
            }
        }catch (MySizeArrayException ex) {
            System.out.println(ex);
        } catch (MyArrayDataException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public String toString() {
        int size = this.array.length;
        String result = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < this.array[i].length; j++) {
                result += this.array[i][j] + "\t";
            }
            result += "\n";
        }
        return result;
    }
}
