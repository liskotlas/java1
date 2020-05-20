package ru.progwards.java2.lessons.app.service;



import ru.progwards.java2.lessons.app.model.Account;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AtmClient implements AccountService {



    private String requiestATM (String request){
        String response = "";
        try (Socket socket = new Socket("localhost", 40000)){
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println(request);
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()){
                response += scanner.nextLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return response;
    }

//        InputStream inputStreamATM = socketATM.getInputStream();
//        OutputStream outputStreamATM = socketATM.getOutputStream();







    @Override
    public double balance(Account account) {
        String request = "GET /balance?id=" + account.getId() + " HTTP/1.1\n" +
                        "hostname: localhost\n\n";
        System.out.println(requiestATM(request));
        return balance(account);
    }

    @Override
    public void deposit(Account account, double amount) {

        String request = "GET /deposit?id=" + account.getId() + "&amount=" + amount + " HTTP/1.1\n" +
                "hostname: localhost\n\n";
        System.out.println(requiestATM(request));

    }

    @Override
    public void withdraw(Account account, double amount) {
        String request = "GET /withdraw?id=" + account.getId() + "&amount=" + amount + " HTTP/1.1\n" +
                "hostname: localhost\n\n";
        System.out.println(requiestATM(request));

    }

    @Override
    public void transfer(Account from, Account to, double amount) {
        String request = "GET /deposit?from=" + from.getId() + "&to=" + to.getId() + "&amount=" + amount + " HTTP/1.1\n" +
                "hostname: localhost\n\n";
        System.out.println(requiestATM(request));

    }
}
