package gorbachev.javacore.lesson2.exeption;

public class MyExeption extends Exception {

    public MyExeption (String msg) {
        super(msg);
    }

    public String MySizeArrayException() {
        return "Вы пытаетесь создать массив не верного размера";
    }
}
