package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName);
            try {
                Scanner scanner = new Scanner(reader);
                char[] res;
                for (int i = 0; scanner.hasNextLine(); i++) {
                    res = scanner.nextLine().toCharArray();
                    for (int f = 0; f < res.length; f++) {
                        try {
                            writer.write(code[(int) res[f]]);
                            writer.write("\n");
                        } finally {
                            writer.close();
                        }
                    }
                }
            }
            finally {
                reader.close();
            }

        } catch (IOException e) {
            try {
                FileWriter log = new FileWriter(logName, true);
                try {
                    log.write(e.getMessage());
                } finally {
                    log.close();
                }
            } catch (IOException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }
}


