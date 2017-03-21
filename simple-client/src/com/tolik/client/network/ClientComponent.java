package com.tolik.client.network;

import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientComponent {

    private Socket socket;

    public ClientComponent() throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 6666), 3000);
    }

    public void sendMessage(String message) {

    }

    public void destroy() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "So... We have a problem with close a socket((");
        }
    }
}