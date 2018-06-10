package ru.gorbachev.javacore.lesson4.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JPanel windowPanel;
    private JButton sendBtn;
    private JEditorPane textEditorChat;
    private JTextPane textChatPane;


    public MainWindow() {
        textChatPane.setEditable(false);
        sendBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Сообщение: " + textEditorChat.getText());
                textEditorChat.setText("");
            }
        });
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }

    public void setWindowPanel(JPanel windowPanel) {
        this.windowPanel = windowPanel;
    }

    public JButton getSenBtn() {
        return sendBtn;
    }

    public void setSenBtn(JButton senBtn) {
        this.sendBtn = senBtn;
    }

    public JEditorPane getTextEditorChat() {
        return textEditorChat;
    }

    public void setTextEditorChat(JEditorPane textEditorChat) {
        this.textEditorChat = textEditorChat;
    }

    public JTextPane getTextChatPane() {
        return textChatPane;
    }

    public void setTextChatPane(JTextPane textChatPane) {
        this.textChatPane = textChatPane;
    }
}
