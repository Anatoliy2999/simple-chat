package com.tolik.server.network;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerComponent {

    private ServerSocket serverSocket;
    private JTextArea jMessage;

    public ServerComponent(JTextArea jMessage, String roomName) throws IOException {
        this.jMessage = jMessage;
        serverSocket = new ServerSocket(6666);
        ClientThread clientThread = new ClientThread(jMessage, serverSocket, roomName);
        Thread thread = new Thread(clientThread);
        thread.start();
    }

    public void destroy(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}