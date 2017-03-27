package com.tolik.server.network;

import javax.swing.*;

public class ClientThread implements Runnable {
    private ServerComponent serverComponent;
    private JTextArea jMassage;

    public ClientThread(JTextArea jMassage, ServerComponent serverComponent) {
        this.jMassage = jMassage;
        this.serverComponent = serverComponent;
    }

    @Override
    public void run() {
        while (true) {
            String message = serverComponent.receiveMessage();
            if (!message.isEmpty()) {
                jMassage.append(message + "\n");
            }
        }
    }
}