package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

    public static void read () {
        Path path = Paths.get("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\Training\\tmpout.txt");
        List<String> strings = List.of();



            try {
                strings = Files.readAllLines(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        strings.forEach(s -> System.out.println(s));

        }


    public static void main(String[] args) {
        read();
//        System.out.println(calcEmpty("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\Training\\tmpout.txt"));
    }
}

