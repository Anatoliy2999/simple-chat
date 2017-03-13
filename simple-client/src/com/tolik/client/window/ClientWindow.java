package com.tolik.client.window;

import javax.swing.*;

public class ClientWindow extends JFrame {
    public ClientWindow() {
        setTitle("Client");
        setSize(600,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}