package ru.progwards.java2.lessons.app.service.impl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ATMServer {


    public static void main(String[] args) {
        try (ServerSocket serverATM = new ServerSocket(40000)) {
            while (true) {
                Socket incoming = serverATM.accept();
                new Thread(new ATMServerThread(incoming)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
