package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName);
            Scanner scanner = new Scanner(reader);
            char[] res;
            String s = "";
            for (int i = 0; scanner.hasNextLine(); i++) {
                res = scanner.nextLine().toCharArray();
                System.out.println(res.length);
                System.out.println(Arrays.toString(res));
                System.out.println(((int) res[1]));
                for (int f = 0; f < res.length; f++) {
                    s += code[((int) res[f])];
                }
                try {
                    writer.write(s);
                    writer.write("\n");
                    s = "";
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    ;
                }
            }
            reader.close();
            writer.close();

        } catch (IOException e) {
            try {
                FileWriter log = new FileWriter(logName, true);
                try {
                    log.write(e.getMessage() + "\n");
                } finally {
                    log.close();
                }
            } catch (IOException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        char[] et = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '"'};
//        System.out.println((int)et[10]);
        codeFile("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\Training\\tmp.txt", "E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\Training\\tmpout.txt", et, "E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\Training\\tmplog.txt");
    }

}


