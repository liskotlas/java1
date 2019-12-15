package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Coder {
    char[] a;

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName, true);
//            Scanner scanner = new Scanner(reader);
            while (reader.ready()) {
                writer.write(code [reader.read()]);
            }
            reader.close();
            writer.close();



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

