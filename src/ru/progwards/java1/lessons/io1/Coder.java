package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        //Вопрос по размеру массива
        char result [][] = new char[5][];


        try {
            FileReader reader = new FileReader(inFileName);

            try {
                Scanner scanner = new Scanner(reader);
                for (int i = 0; scanner.hasNextLine(); i++) {
                    result[i] = (scanner.nextLine()).toCharArray();
                }
                for (int i = 0; i < result.length; i++) {
                    for (int f = 0; f < result[i].length; f++) {
                        result[i][f] = code[(int) result[i][f]];
                    }
                }
            } finally {
                reader.close();
            }
//            Вопрос по правильности TRY
            try {
                FileWriter writer = new FileWriter(outFileName, true);
                try {
                    for (int i = 0; i < result.length; i++) {
                        writer.write(result[i].toString());
                    }

                } finally {
                    writer.close();
                }
            }
            catch (IOException e){
            }
        }

        catch (IOException e) {
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

