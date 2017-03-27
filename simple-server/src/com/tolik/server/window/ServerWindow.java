package com.tolik.server.window;

import com.tolik.server.network.ClientThread;
import com.tolik.server.network.ServerComponent;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ServerWindow extends JFrame {
    private JButton openRoomButton = new JButton("Open Room");
    private JTextField roomField = new JTextField("name Room");
    private JTextArea jMassage = new JTextArea();
    private JScrollPane jScrollPane = new JScrollPane(jMassage);
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
        jMassage.setEditable(false);

        openRoomButton.addActionListener(e -> {
            openRoomButton.setEnabled(false);
            roomField.setEnabled(false);
            try {
                serverComponent = new ServerComponent();
                ClientThread clientThread = new ClientThread(jMassage, serverComponent);
                Thread thread = new Thread(clientThread);
                thread.start();

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
}