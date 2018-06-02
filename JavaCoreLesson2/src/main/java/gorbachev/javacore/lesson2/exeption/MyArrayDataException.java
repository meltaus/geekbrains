package gorbachev.javacore.lesson2.exeption;

public class MyArrayDataException extends Exception {

    private static int row;
    private static int column;

    public MyArrayDataException(int row, int column) {
        super("В ячейке не верный тип данных");
        this.row = row;
        this.column = column;
    }

    public MyArrayDataException(String msg) {
        super(String.format("%s В строке %d, в ячейке %d не верный тип данных", msg, this.row, this.column));
    }
}
