package com.tolik.client.network;

import javax.swing.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientComponent {

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public ClientComponent() throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 6666), 3000);
        OutputStream outputStream = socket.getOutputStream();
        dataOutputStream = new DataOutputStream(outputStream);
        InputStream inputStream = socket.getInputStream();
        dataInputStream = new DataInputStream(inputStream);
    }

    public void sendMessage(String message) {
        try {
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Send message problem.");
        }
    }

    public void destroy() {
        try {
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
        }
    }

    public String receiveMessage() {
        try {
            return dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Receive message problem.");
        }
        return "";
    }

    public boolean checkRoom(String roomName) {
        sendMessage("`ROOM");
        String message = receiveMessage();
        return message.equals(roomName);
    }
}