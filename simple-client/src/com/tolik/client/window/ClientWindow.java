package com.tolik.client.window;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JFrame {
    public ClientWindow() {
        setTitle("Client");
        setSize(250, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel jPanel = new JPanel();
        JPanel jPanel1 = new JPanel();
        JButton send = new JButton("Send");
        JTextField room = new JTextField();
        JTextField inPut = new JTextField();
        JLabel labelRoom = new JLabel("Room");
        JLabel labelName = new JLabel("Nick name");
        JTextField name = new JTextField();
        JButton connect = new JButton("Connect");

        jPanel.setLayout(new GridLayout(1, 2));
        jPanel.add(inPut);
        jPanel.add(send);

        jPanel1.setLayout(new GridLayout(3, 2));
        jPanel1.add(labelRoom);
        jPanel1.add(room);
        jPanel1.add(labelName);
        jPanel1.add(name);
        jPanel1.add(connect);

        add(jPanel, BorderLayout.PAGE_END);
        add(jPanel1, BorderLayout.PAGE_START);
    }
}