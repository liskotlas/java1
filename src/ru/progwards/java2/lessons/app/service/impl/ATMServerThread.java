package ru.progwards.java2.lessons.app.service.impl;


import ru.progwards.java2.lessons.app.Store;
import ru.progwards.java2.lessons.app.model.Account;
import ru.progwards.java2.lessons.app.service.DBStoreService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class ATMServerThread implements Runnable {

    Socket socket;

    public ATMServerThread(Socket socket) {
        this.socket = socket;
    }

    public String responseATM(String request) {
        System.out.println(request);
        HashMap<String, String> parameters = new HashMap<>();
        try {
//        Получение названия метода из request
            String method = request.substring(request.lastIndexOf("GET /") + 5, request.indexOf("?"));

//        Получение параметров из request и запись их в Map
            String[] strResp = request.substring(request.indexOf("?") + 1, request.indexOf("HTTP")).trim().split("&");
            for (String strPair : strResp) {
                String[] pair = strPair.split("=");
                if (pair.length > 1) {
                    parameters.put(pair[0], pair[1]);
                }
            }

            AccountServiceImpl tmp = new AccountServiceImpl(new DBStoreService());

//        Метод Баланс
            if (method.equals("balance")) {
                System.out.println("Метод Баланс");
                Account account = Store.getAccountDB(parameters.get("id"));
                System.out.println(account.getAmount());

                String response = "HTTP/1.1 201 OK\n" +
                        "Content-Type: text/html; charset=utf-8\n" +
                        "Content-Length: 1234\n\n" +
                        "Баланс " + tmp.balance(account);
                System.out.println("Баланс = " + tmp.balance(account));
                return response;
            }
//        Метод перевод
            if (method.equals("transfer")) {
                Account from = Store.getAccountDB(parameters.get("from"));
                Account to = Store.getAccountDB(parameters.get("to"));
                double amount = Double.parseDouble(parameters.get("amount"));
                tmp.transfer(from, to, amount);
                String response = "HTTP/1.1 200 OK\n" +
                        "Content-Type: text/html; charset=utf-8\n" +
                        "Content-Length: 1234\n\n" +
                        "Перевод " + amount;
                return response;
            }

//        Пополнение счета
            if (method.equals("deposit")) {
                Account account = Store.getAccountDB(parameters.get("id"));
                double amount = Double.parseDouble(parameters.get("amount"));
                tmp.deposit(account, amount);
                String response = "HTTP/1.1 202 OK\n" +
                        "Content-Type: text/html; charset=utf-8\n" +
                        "Content-Length: 1234\n\n" +
                        "Пополнение " + amount;
                return response;
            }

//        Снятие наличных
            if (method.equals("withdraw")) {
                Account account = Store.getAccountDB(parameters.get("id"));
                double amount = Double.parseDouble(parameters.get("amount"));
                tmp.withdraw(account, amount);
                String response = "HTTP/1.1 203 OK\n" +
                        "Content-Type: text/html; charset=utf-8\n" +
                        "Content-Length: 1234\n\n";
                return response;
            }
        } catch (Exception e) {
            String response = "HTTP/1.1 405 Uncorrect request\n" +
                    "Content-Type: text/html; charset=utf-8\n" +
                    "Content-Length: 1234\n\n";
            return response;

        }
        String response = "HTTP/1.1 400 ErrorATM\n" +
                "Content-Type: text/html; charset=utf-8\n" +
                "Content-Length: 1234\n\n";
        return response;

    }


    @Override
    public void run() {

/*      GET /withdraw?id=hevhebhbvhefbv&amount=1000 HTTP/1.1
/*      GET /balance?id=hevhebhbvhefbv HTTP/1.1
        GET /transfer?from=hevhebhbvhefbv&id=hevhebhbvhefbv&to=jevfjblsdbfvlb&amount=1000 HTTP/1.1
        hostname: localhost
        GET /deposit?id=hevhebhbvhefbv&amount=1000 HTTP/1.1

        */

        System.out.println("Соединение");

        try (InputStream isATM = socket.getInputStream()) {
            String request = "";
            System.out.println("Ждем");
            Scanner scanner = new Scanner(isATM);
            while (scanner.hasNextLine()) {
                request = scanner.nextLine();
                String response = responseATM(request);
                System.out.println(response);
                if (response.equals("EXIT")) {
                    break;
                }
                OutputStream osATM = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(osATM);
                pw.println(response);
                pw.flush();
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
