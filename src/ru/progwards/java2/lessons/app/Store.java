package ru.progwards.java2.lessons.app;


import ru.progwards.java2.lessons.app.model.Account;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

public class Store {

    private static Map<String, Account> store = new HashMap<>();

    static {
//        for (int i = 0; i < 10; i++) {
//            Account acc = new Account();
//            String id = UUID.randomUUID().toString();
//            acc.setId(id);
//            acc.setPin(1000 + i);
//            acc.setHolder("Account_" + i);
////            acc.setDate(new Date(System.currentTimeMillis() + 365 * 24 * 3600 * 1000));
//            acc.setAmount(Math.random() * 1_000_000);
//
//            store.put(acc.getId(), acc);
//
//        }
//        String result = "";
//        for (Map.Entry<String, Account> entry : store.entrySet()) {
//            result += entry.getKey() + "|" + entry.getValue().getHolder() + "|" + "|" + entry.getValue().getAmount() + "|" + entry.getValue().getPin() + "\n";
//        }
//
//        try {
//            FileWriter fileWriter = new FileWriter("/Users/lis_macbook/IdeaProjects/java1/src/ru/progwards/java2/lessons/app/store1");
//            System.out.println(result);
//            fileWriter.write(result);
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        Path path = Paths.get("/Users/lis_macbook/IdeaProjects/java1/src/ru/progwards/java2/lessons/app/store1");

        try {
            List<String> strings = Files.readAllLines(path);

//            for (String s : strings) {
//                System.out.println(s);
//            }

//Tue May 12 16:13:04 MSK 2020
            for (String s : strings) {
                Account account = new Account();
                String[] strings1 = s.split("[|]");
//                System.out.println(strings1[3]);
                account.setId(strings1[0]);
                account.setHolder(strings1[1]);
//                account.setDate(LocalDateTime.parse(strings1[2], DateTimeFormatter.ofPattern("")));
                account.setAmount(Double.parseDouble(strings1[2]));
                account.setPin(Integer.parseInt(strings1[3]));
                store.put(strings1[0], account);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Map<String, Account> getStore() {
        return store;
    }

    public static void setStore() {

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("/Users/lis_macbook/IdeaProjects/java1/src/ru/progwards/java2/lessons/app/store1"));
            for (var entry : store.entrySet()) {
                Account account = entry.getValue();
                String acc = account.getId() + "|" + account.getHolder() + "|" + account.getAmount() + "|" + account.getPin() + "\n";
                dataOutputStream.flush();
                dataOutputStream.writeBytes(acc);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static Account getAccountDB(String id) {
        Account account = new Account();
        String sql = "SELECT * FROM store WHERE id=?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AtmDB?serverTimezone=Europe/Moscow&useSSL=false", "root", "12345678")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println(resultSet.next());
            if (resultSet.next()) {
                account.setId(resultSet.getString("ID"));
                account.setHolder(resultSet.getString("HOLDER"));
                account.setAmount(resultSet.getDouble("AMOUNT"));
                account.setPin(resultSet.getInt("PIN"));
                account.setDate(resultSet.getDate("DATE"));
//                System.out.println(resultSet.getString("DATE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public static void updateAccountDB(Account account) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AtmDB?serverTimezone=Europe/Moscow&useSSL=false", "root", "12345678")) {
            String sql = "UPDATE store SET HOLDER=?, AMOUNT=?, PIN=?, DATE=? WHERE ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(4, account.getId());
            preparedStatement.setString(1, account.getHolder());
            preparedStatement.setDouble(2, account.getAmount());
            preparedStatement.setInt(3, account.getPin());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertAccountDB(Account account) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AtmDB?serverTimezone=Europe/Moscow&useSSL=false", "root", "12345678")) {
            String sql = "INSERT INTO store (ID, HOLDER, AMOUNT, PIN) Values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getId());
            preparedStatement.setString(2, account.getHolder());
            preparedStatement.setDouble(3, account.getAmount());
            preparedStatement.setInt(4, account.getPin());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAccountDB(String id) {
        Account account = new Account();
        String sql = "DELETE FROM store WHERE id=?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AtmDB?serverTimezone=Europe/Moscow&useSSL=false", "root", "12345678")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        System.out.println(LocalDateTime.now());
        DateTimeFormatter eu = DateTimeFormatter.ofPattern("dd MMMM yyyy г. HH:mm:ss");
        System.out.println("Баланс = " + getAccountDB("ekbvlebvkwbvkd").getAmount() + " Дата " + getAccountDB("ekbvlebvkwbvkd").getDate().toLocalDate());;

    }

}
