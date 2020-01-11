package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.util.*;

public class SalesInfo {
    ArrayList<String[]> arrayList = new ArrayList<>();

    public int loadOrders(String fileName) {

        int i = 0;

        try (FileReader fileReader = new FileReader(fileName)) {
            try (Scanner scanner = new Scanner(fileReader)) {
                for (; scanner.hasNextLine(); ) {
                    String string = scanner.nextLine();
                    String[] words = new String[4];
                    for (String word : string.split(",")) {
                        if (i > 3) {
                            i = 0;
                            break;
                        }
                        if (i == 2 || i == 3) {
                            try {
                                int a = Integer.parseInt(word.trim());
                                words[i] = word.trim();
                            } catch (Exception e) {
                                i = 0;
                                break;
                            }
                        }
                        words[i] = word.trim();
                        i++;
                    }
                    if (i < 4) {
                        i = 0;
                        continue;
                    }

                    arrayList.add(words);
                    i = 0;
                }
                for (String[] s : arrayList) {
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrayList.size();
    }

    public Map<String, Double> getGoods() {
        Map<String, Double> result = new TreeMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String[] s = arrayList.get(i);
            if (result.containsKey(arrayList.get(i)[1])) {
                result.put(s[1], result.get(s[1]) + Double.parseDouble(s[3]));
            }
            result.putIfAbsent(s[1], Double.parseDouble(s[3]));
        }
        return result;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers(){
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> result =  new TreeMap<>();
        for (int i = 0; i < arrayList.size(); i++){
            String[] s = arrayList.get(i);
            if (result.containsKey(s[0])){

                var simpleEntry = result.get(s[0]);
                result.put(s[0], new AbstractMap.SimpleEntry<>(simpleEntry.getKey() + Double.parseDouble (s[3]), (simpleEntry.getValue() + Integer.parseInt(s[2]))));
            }
            result.putIfAbsent(s[0], new AbstractMap.SimpleEntry<>(Double.parseDouble(s[3]),Integer.parseInt(s[2])));
        }
        return result;
    }


    public static void main(String[] args) {
        SalesInfo salesInfo = new SalesInfo();
        System.out.println(salesInfo.loadOrders("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\maps\\Test") + "\n");


        for (var entry : salesInfo.getGoods().entrySet()) {
            System.out.println(entry);
        }
        System.out.println();


        for (var entry : salesInfo.getCustomers().entrySet()) {
            System.out.println(entry);
        }
    }
}


