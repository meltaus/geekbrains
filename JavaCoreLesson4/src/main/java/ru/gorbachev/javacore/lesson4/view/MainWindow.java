package ru.gorbachev.javacore.lesson4.view;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JPanel windowPanel;
    private JButton sendBtn;
    private JTextField textEditorChat;
    private JTextPane textChatPane;


    public MainWindow() {
        textChatPane.setEditable(false);
        textChatPane.setText( "Главное окно чата. Здесь будет происходить общение" );
        //По нажатии на кнопку добавлем тест в textChatPane и очищаем textEditorChar
        sendBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StyledDocument doc = textChatPane.getStyledDocument();
                SimpleAttributeSet keyWord = new SimpleAttributeSet();

                try
                {
                    String str = "\nroot: " + textEditorChat.getText();
                    doc.insertString(doc.getLength(), str, keyWord );
                }
                catch(Exception ex) { System.out.println(ex); }
                System.out.println("Сообщение: " + textEditorChat.getText());
                textEditorChat.setText("");
            }
        });
        //Обработка нажатия клаиши Enter. Действие аналогично обработки нажатия кнопки
        textEditorChat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StyledDocument doc = textChatPane.getStyledDocument();
                SimpleAttributeSet keyWord = new SimpleAttributeSet();

                try
                {
                    String str = "\nroot: " + textEditorChat.getText();
                    doc.insertString(doc.getLength(), str, keyWord );
                }
                catch(Exception ex) { System.out.println(ex); }
                System.out.println("Сообщение: " + textEditorChat.getText());
                textEditorChat.setText("");
            }
        });
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
