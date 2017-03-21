package com.tolik.server.network;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerComponent {

    private ServerSocket serverSocket;

    public ServerComponent() throws IOException {
        serverSocket = new ServerSocket(6666);
        serverSocket.accept();
        JOptionPane.showMessageDialog(null, "Connected");
    }

    public String receiveMessage() {
        return "";
    }

    public void destroy() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"So... We have a problem with close a socket((");
        }
    }
}