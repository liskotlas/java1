package ru.progwards.java2.lessons.app;


import ru.progwards.java2.lessons.app.model.Account;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    private static Map<String, Account> store = new HashMap<>();

    static {
//        for (int i = 0; i < 10; i++) {
//            Account acc = new Account();
//            String id = UUID.randomUUID().toString();
//            acc.setId(id);
//            acc.setPin(1000 + i);
//            acc.setHolder("Account_" + i);
//            acc.setDate(new Date(System.currentTimeMillis() + 365 * 24 * 3600 * 1000));
//            acc.setAmount(Math.random() * 1_000_000);
//
//            store.put(acc.getId(), acc);
//
//        }
//        String result = "";
//        for (Map.Entry<String, Account> entry : store.entrySet()) {
//            result += entry.getKey() + "|" + entry.getValue().getHolder() + "|" + entry.getValue().getDate().toString() + "|" + entry.getValue().getAmount() + "|" + entry.getValue().getPin() + "\n";
//        }
//
//        try {
//            FileWriter fileWriter = new FileWriter("C:\\store.txt");
//            System.out.println(result);
//            fileWriter.write(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Path path = Paths.get("C:\\store1.txt");

        try {
            List<String> strings = Files.readAllLines(path);

            for (String s : strings) {
                System.out.println(s);
            }

//Tue May 12 16:13:04 MSK 2020
            for (String s : strings) {
                Account account = new Account();
                String[] strings1 = s.split("//");
//                System.out.println(strings1[3]);
                account.setId(strings1[0]);
                account.setHolder(strings1[1]);
//                account.setDate(LocalDateTime.parse(strings1[2], DateTimeFormatter.ofPattern("")));
                account.setAmount(Double.parseDouble(strings1[2]));
                account.setPin(Integer.parseInt(strings1[3]));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Map<String, Account> getStore() {
        return store;
    }

    public static void setStore(){

    }

}
