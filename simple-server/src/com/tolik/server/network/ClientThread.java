package com.tolik.server.network;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientThread implements Runnable {
    private JTextArea jMessage;
    private DataInputStream dataInputStream;
    private Socket socket;
    private ServerSocket serverSocket;

    public ClientThread(JTextArea jMassage, ServerSocket serverSocket) {
        this.jMessage = jMassage;
        this.serverSocket = serverSocket;
    }

    private void init() {
        try {
            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());

            ClientThread clientThread = new ClientThread(jMessage, serverSocket);
            Thread thread = new Thread(clientThread);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        init();
        while (true) {
            String message = receiveMessage();
            if (message.isEmpty()) {
                System.out.println("Connection is destroyed");
                break;
            }
            jMessage.append(message + "\n");
        }
        destroy();
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
            socket.close();

        } catch (IOException e) {
        }
    }
}