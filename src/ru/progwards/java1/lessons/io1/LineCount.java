package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
        int i = 0;
        try {
            FileReader reader = new FileReader(fileName);
            try {
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine()) {
                    if (scanner.nextLine().compareTo("") == 0) {
                        i++;
                    }
                }
            } finally {
                reader.close();
            }
        } catch (Exception e) {
            return -1;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(calcEmpty("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\Training\\tmp.txt"));
    }
}

