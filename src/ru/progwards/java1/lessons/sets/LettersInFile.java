package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeSet;

public class LettersInFile {

    public static String process(String fileName) throws Exception{
        String resultLine = "";
        TreeSet <Character> stringResult = new TreeSet<>();
        FileReader reader = new FileReader(fileName);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            char[] a = scanner.nextLine().toCharArray();
            for (char b : a) {
                if (Character.isAlphabetic(b)) {
                    stringResult.add(b);
                }
            }
        }

        for (Character c: stringResult){
            resultLine += c;
        }
        return  resultLine;
    }

    public static void main(String[] args) {
        try {
            System.out.println(process("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\sets\\Test"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
