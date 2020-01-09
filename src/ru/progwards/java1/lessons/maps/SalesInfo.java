package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.util.*;

public class SalesInfo {
    static ArrayList<String[]> arrayList = new ArrayList<>();

    public static int loadOrders(String fileName) {

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
//                    System.out.println(Arrays.deepToString(words));
                    arrayList.add(words);

//                    System.out.println(Arrays.deepToString(arrayList.get(aL)));
//                    aL++;
                    i = 0;
                }
                for (String[] s : arrayList) {
//                    System.out.println(Arrays.deepToString(s));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        for (String[] s : arrayList){
//            System.out.println(Arrays.deepToString(s));
//        }
        return arrayList.size();
    }

    public static Map<String, Double> getGoods() {
        Map<String, Double> result = new TreeMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String[] s = arrayList.get(i);
//            System.out.println(Arrays.deepToString(arrayList.get(i)));
            if (result.containsKey(arrayList.get(i)[1])) {
                result.put(s[1], result.get(s[1]) + Double.parseDouble(s[2]) * Double.parseDouble(s[3]));
            }
            result.putIfAbsent(s[1], Double.parseDouble(s[2]) * Double.parseDouble(s[3]));
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(loadOrders("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\maps\\Test"));

        for (var entry : getGoods().entrySet()) {
            System.out.println(entry);
//        }
        }
    }
}


