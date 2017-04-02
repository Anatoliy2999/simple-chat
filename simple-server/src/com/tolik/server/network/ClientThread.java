package com.tolik.server.network;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientThread implements Runnable {
    private JTextArea jMessage;
    private DataInputStream dataInputStream;
    private Socket socket;
    private ServerSocket serverSocket;
    private DataOutputStream dataOutputStream;
    private String roomName;

    public ClientThread(JTextArea jMassage, ServerSocket serverSocket, String roomName) {
        this.jMessage = jMassage;
        this.serverSocket = serverSocket;
        this.roomName = roomName;
    }

    private void init() {
        try {
            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            OutputStream outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);

            ClientThread clientThread = new ClientThread(jMessage, serverSocket, roomName);
            Thread thread = new Thread(clientThread);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        init();
        while (true) {
            String message = receiveMessage();
            if (message.equals("`ROOM")) {
                sendMessage(roomName);
                continue;
            }
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