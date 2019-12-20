package ru.progwards.java1.lessons.Training;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Java_9_3 {
    private int lineCount(String filename) throws IOException{
        int i = 0;
        try {
            FileReader reader = new FileReader(filename);
            try {
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine()){
                    String s = scanner.nextLine();
                    i++;
                }

            }
            finally {
                reader.close();
            }
        }
        catch (IOException e){
            throw new IOException("файл не найден");
        }
        return i;
    }

    public static void main(String[] args) throws IOException {
        Java_9_3 s = new Java_9_3();
        System.out.println(s.lineCount("\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\Training\\tmp.txt"));

    }
}

