package com.tolik.server.window;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {
    private JButton openRoomButton = new JButton("Open Room");
    private JTextField roomField = new JTextField("name Room");
    private JTextArea jMassage = new JTextArea();
    private JScrollPane jScrollPane = new JScrollPane(jMassage);

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
            roomField.setEnabled(false);
            jMassage.setText("1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n");
        });

        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(roomField, BorderLayout.PAGE_START);
        add(jScrollPane, BorderLayout.CENTER);
        add(openRoomButton, BorderLayout.PAGE_END);
    }
}