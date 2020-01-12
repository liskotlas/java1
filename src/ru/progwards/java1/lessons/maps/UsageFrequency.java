package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UsageFrequency {

    Map<Character, Integer> getLetters = new HashMap<>();
    Map<String, Integer> getWords = new TreeMap<>();

    String string = "";

    public void processFile(String fileName) {

        try (FileReader fileReader = new FileReader(fileName)) {
            try (Scanner scanner = new Scanner(fileReader)) {
//               Чтение файла в строку
                while (scanner.hasNextLine()) {
                    string += scanner.nextLine() + " ";

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public Map<Character, Integer> getLetters(){
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (Character.isLetterOrDigit(ch)) {
                if (getLetters.containsKey(ch)) {
                    getLetters.replace(ch, getLetters.get(ch) + 1);
                    continue;
                }
            getLetters.put(ch, 1);
            }
        }
        return getLetters;
    }
//\\\\W_]+   ( "[^\\w\\d\\s]"))   ( "[^a-zA-Z_0-9]"))
    public Map<String, Integer> getWords(){
        for (String word : string.split( "[^a-zA-Z_а-яА-Я_0-9]")) {
            word = word.trim();
            if (getWords.containsKey(word)) {
                getWords.replace(word, getWords.get(word) + 1);
                continue;
            }
            getWords.put(word, 1);
        }
        getWords.remove("");
        return getWords;
    }

//    public static void main(String[] args) {
//        UsageFrequency usageFrequency = new UsageFrequency();
//        usageFrequency.processFile("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\maps\\wiki.test.tokens");
//        for (var entry : usageFrequency.getWords().entrySet()){
//            System.out.println(entry);
//        }
//
////        System.out.println(Integer.parseInt("fgh2"));
//
////        System.out.println(getLetters().size());
//    }

}

