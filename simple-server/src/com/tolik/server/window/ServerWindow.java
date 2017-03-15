package com.tolik.server.window;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {
    private JButton openRoomButton = new JButton("Open Room");
    private JTextField roomField = new JTextField("World");
    private JTextArea jMassage = new JTextArea();

    public ServerWindow() {
        setTitle("Server");
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        jMassage.setEditable(false);
        openRoomButton.addActionListener(e -> {
            openRoomButton.setEnabled(false);
        });
        add(roomField, BorderLayout.PAGE_START);
        add(jMassage, BorderLayout.CENTER);
        add(openRoomButton, BorderLayout.PAGE_END);
    }
}