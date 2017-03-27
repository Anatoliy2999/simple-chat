package com.tolik.server.network;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerComponent {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream dataInputStream;
    private JTextArea jMessage;

    public ServerComponent(JTextArea jMessage) throws IOException {
        this.jMessage = jMessage;
        serverSocket = new ServerSocket(6666);
        clientSocket = serverSocket.accept();
        JOptionPane.showMessageDialog(null, "Connected");
        InputStream inputStream = clientSocket.getInputStream();
        dataInputStream = new DataInputStream(inputStream);
    }

    public String receiveMessage() {
        try {
            return dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void destroy() {
        try {
            dataInputStream.close();
            serverSocket.close();
        } catch (IOException e) {
        }
    }
}