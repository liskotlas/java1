package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Coder {
    char[] a;

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        String s = "";

        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName);
//            Scanner scanner = new Scanner(reader);
            while (reader.ready()) {
                s += code [reader.read()];
            }
            writer.write(s);


        } catch (IOException e) {
            try {
                FileWriter log = new FileWriter(logName, true);
                log.write(e.getMessage());
            } catch (IOException e_log) {
                System.out.println(e_log.getMessage());
            }
        }
    }
}

