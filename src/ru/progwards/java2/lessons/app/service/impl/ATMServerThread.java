package ru.progwards.java2.lessons.app.service.impl;

import ru.progwards.java2.lessons.app.Store;
import ru.progwards.java2.lessons.app.model.Account;

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

//        Получение названия метода из request
        String method = request.substring(request.lastIndexOf("GET /")+5, request.indexOf("?"));

//        Получение параметров из request и запись их в Map
        String[] strResp = request.substring(request.indexOf("?")+1, request.indexOf("HTTP")).trim().split("&");
        for (String strPair : strResp) {
            String[] pair = strPair.split("=");
            if (pair.length > 1) {
                parameters.put(pair[0], pair[1]);
            }
        }

//        for (var entry : parameters.entrySet()){
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }

        AccountServiceImpl tmp = new AccountServiceImpl();


//        Метод Баланс
        if (method.equals("balance")) {
            System.out.println("Метод Баланс");
//            Account account = Store.getStore().get(parameters.get("id"));
            System.out.println(parameters.get("id"));
            HashMap<>

            String response = "HTTP/1.1 205 OK\n" +
                    "Content-Type: text/html; charset=utf-8\n" +
                    "Content-Length: 1234\n\n";
//            System.out.println("Баланс = " + tmp.balance(account));
//            System.out.println("Аккаунт IS" + account.getId());
            return response;
        }
//        Метод перевод
        if (method.equals("transfer")) {
            Account from = Store.getStore().get(parameters.get("from"));
            Account to = Store.getStore().get(parameters.get("to"));
            double amount = Double.parseDouble(Store.getStore().get(parameters.get("amount")).toString());
            String response = "HTTP/1.1 200 OK\n" +
                    "Content-Type: text/html; charset=utf-8\n" +
                    "Content-Length: 1234\n\n";
            return response;
        }

//        Пополнение счета
        if (method == "deposit") {
            Account account = Store.getStore().get(parameters.get("id"));
            double amount = Double.parseDouble(Store.getStore().get(parameters.get("amount")).toString());
            tmp.deposit(account, amount);
            String response = "HTTP/1.1 200 OK\n" +
                    "Content-Type: text/html; charset=utf-8\n" +
                    "Content-Length: 1234\n\n";
            return response;
        }

//        Снятие наличных
        if (method == "withdraw") {
            Account account = Store.getStore().get(parameters.get("id"));
            double amount = Double.parseDouble(Store.getStore().get(parameters.get("amount")).toString());
            tmp.withdraw(account, amount);
            String response = "HTTP/1.1 200 OK\n" +
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

/*      GET /balance?id=cbf61d6f-ea3f-4f9a-9c5c-bd11dd02c392 HTTP/1.1
        hostname: localhost


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
                if (response.equals("EXIT")){
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
