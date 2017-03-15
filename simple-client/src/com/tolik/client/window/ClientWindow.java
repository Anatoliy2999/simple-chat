package com.tolik.client.window;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JFrame {
    private JTextField roomField = new JTextField();
    private JLabel labelRoom = new JLabel("Room");
    private JLabel labelName = new JLabel("Nick name");
    private JTextField nameField = new JTextField();
    private JButton connectButton = new JButton("Connect");
    private JButton sendButton = new JButton("Send");
    private JTextField inputField = new JTextField();
    private JButton disconnectButton = new JButton("Disconnect");


    public ClientWindow() {
        setTitle("Client");
        setSize(250, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        initConnectionComponent();
        initSendComponent();
    }

    public void initConnectionComponent() {
        JPanel connectionPanel = new JPanel();

        connectionPanel.setLayout(new GridLayout(3, 2));
        connectionPanel.add(labelRoom);
        connectionPanel.add(roomField);
        connectionPanel.add(labelName);
        connectionPanel.add(nameField);

        connectionPanel.add(connectButton);
        connectionPanel.add(disconnectButton);

        connectButton.addActionListener(e -> {
            connectButton.setEnabled(false);
            disconnectButton.setEnabled(true);
            roomField.setEnabled(false);
            nameField.setEnabled(false);
            inputField.setEnabled(true);
            sendButton.setEnabled(true);
        });

        disconnectButton.addActionListener(e -> {
            disconnectButton.setEnabled(false);
            connectButton.setEnabled(true);
            roomField.setEnabled(true);
            nameField.setEnabled(true);
            inputField.setEnabled(false);
            sendButton.setEnabled(false);
        });

        add(connectionPanel, BorderLayout.PAGE_START);
    }

    public void initSendComponent() {
        JPanel jPanel = new JPanel();

        inputField.setEnabled(false);
        sendButton.setEnabled(false);

        jPanel.setLayout(new GridLayout(1, 2));
        jPanel.add(inputField);
        jPanel.add(sendButton);

        add(jPanel, BorderLayout.PAGE_END);
    }
}