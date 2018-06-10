package ru.gorbachev.javacore.lesson4;

import ru.gorbachev.javacore.lesson4.view.MainWindow;

import javax.swing.*;

public class Lesson4 {

    public static void main (String[] args) {
        JFrame mainWindows = new JFrame("Чат");
        mainWindows.setContentPane(new MainWindow().getWindowPanel());
        mainWindows.setBounds(50, 50, 600, 500);
        mainWindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindows.setVisible(true);
    }
}
