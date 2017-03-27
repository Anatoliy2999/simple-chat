package com.tolik.client.window;

import com.tolik.client.network.ClientComponent;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClientWindow extends JFrame {
    private JTextField roomField = new JTextField();
    private JLabel labelRoom = new JLabel("Room");
    private JLabel labelName = new JLabel("Nick name");
    private JTextField nameField = new JTextField();
    private JButton connectButton = new JButton("Connect");
    private JButton sendButton = new JButton("Send");
    private JTextField inputField = new JTextField();
    private JButton disconnectButton = new JButton("Disconnect");
    private ClientComponent clientComponent;

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
            if (roomField.getText().isEmpty() || nameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all field!!!");
                return;
            }
            connectButton.setEnabled(false);
            disconnectButton.setEnabled(true);
            roomField.setEnabled(false);
            nameField.setEnabled(false);
            inputField.setEnabled(true);
            sendButton.setEnabled(true);
            try {
                clientComponent = new ClientComponent();
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,"Connection failed");
            }
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

        sendButton.addActionListener(e -> {
            String nikName = nameField.getText();
            String massage = inputField.getText();
            if (!massage.isEmpty()) {
                clientComponent.sendMessage(String.format("%s: %s", nikName, massage));
            }
        });

        inputField.setEnabled(false);
        sendButton.setEnabled(false);
        disconnectButton.setEnabled(false);

        jPanel.setLayout(new GridLayout(1, 2));
        jPanel.add(inputField);
        jPanel.add(sendButton);

        add(jPanel, BorderLayout.PAGE_END);
    }
}