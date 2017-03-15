package com.tolik.server.window;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {
    public ServerWindow() {
        setTitle("Server");
        setSize(250, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JButton openRoom = new JButton("Open Room");
        JLabel labelRoom = new JLabel("World");

        String[] massage = {"1", "2", "2", "2", "2"};

        JScrollPane scrollPane = new JScrollPane();
        JList<String> jMassage = new JList<String>(massage);

        scrollPane.setViewportView(jMassage);
        jMassage.setLayoutOrientation(JList.VERTICAL);

        add(labelRoom, BorderLayout.PAGE_START);
        add(jMassage, BorderLayout.CENTER);
        add(openRoom, BorderLayout.PAGE_END);
    }
}