package com.tolik.server.window;

import com.tolik.server.network.ServerComponent;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ServerWindow extends JFrame {
    private JButton openRoomButton = new JButton("Open Room");
    private JTextField roomField = new JTextField("name Room");
    private JTextArea jMessage = new JTextArea();
    private JScrollPane jScrollPane = new JScrollPane(jMessage);
    private ServerComponent serverComponent;

    public ServerWindow() {
        setTitle("Server");
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        jMessage.setEditable(false);

        openRoomButton.addActionListener(e -> {
            openRoomButton.setEnabled(false);
            roomField.setEnabled(false);
            try {
                serverComponent = new ServerComponent(jMessage, roomField.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Connection from client is failed");
            }
        });

        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(roomField, BorderLayout.PAGE_START);
        add(jScrollPane, BorderLayout.CENTER);
        add(openRoomButton, BorderLayout.PAGE_END);
    }

    @Override
    public void dispose() {
        serverComponent.destroy();
        super.dispose();
    }
}