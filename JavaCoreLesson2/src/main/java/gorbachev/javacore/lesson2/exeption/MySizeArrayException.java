package gorbachev.javacore.lesson2.exeption;

public class MySizeArrayException extends Exception {

    private static String msg;

    public MySizeArrayException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MySizeArrayException() {
    }

    @Override
    public String toString() {
        if (this.msg != null) {
            return msg;
        } else {
            return "Массив неверного размера";
        }
    }
}
