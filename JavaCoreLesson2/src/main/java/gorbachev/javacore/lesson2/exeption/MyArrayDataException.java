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
        super(msg);
    }

    @Override
    public String toString() {
        return "В строке " + this.row + " в ячейке " + this.column + "" +
                " неверный тип данных";
    }
}
