package com.tolik.client.network;

import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientComponent {

    private Socket socket;
    private DataOutputStream dataOutputStream;

    public ClientComponent() throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 6666), 3000);
        OutputStream outputStream = socket.getOutputStream();
        dataOutputStream = new DataOutputStream(outputStream);
    }

    public void sendMessage(String message) {
        try {
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Stream problem");
        }
    }

    public void destroy() {
        try {
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
        }
    }
}