package ru.gorbachev.javacore.lesson4;

import ru.gorbachev.javacore.lesson4.view.MainWindow;

import javax.swing.*;

public class Lesson4 {

    public static void main (String[] args) {
        JFrame mainWindows = new JFrame("Чат");
        mainWindows.setContentPane(new MainWindow().getWindowPanel());
        mainWindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindows.pack();
        mainWindows.setVisible(true);
    }
}
