package gorbachev.javacore.lesson2.exeption;

public class MySizeArrayException extends Exception {

    public MySizeArrayException(String msg) {
        super(msg);
    }

    public MySizeArrayException() {
        super("Вы пытаетесь создать массив не верного размера");
    }
}
