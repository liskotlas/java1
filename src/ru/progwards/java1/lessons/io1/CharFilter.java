package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        char [] b = filter.toCharArray();
        String string = "";
        try {
        FileReader reader = new FileReader(inFileName);
            try {
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()){
                char [] a = scanner.nextLine().toCharArray();
                for (int i = 0; i < a.length; i++) {
                    for (int f = 0; f < b.length; f++) {
                        if (a[i] == b[f]) {
                            char[] c = new char[a.length - 1];
                            System.arraycopy(a, 0, c, 0, i);
                            System.arraycopy(a, i + 1, c, i, a.length - i - 1);
                            a = Arrays.copyOf(c, c.length);
                            --i;
                        }
                    }
                }
                for (int i = 0; i < a.length; i++){
                    string += a [i];
                }
            }
        }
            finally {
                reader.close();
            }
        }
        catch (IOException e){
            throw e;
        }
        try {
            FileWriter writer = new FileWriter(outFileName);
            try{
                writer.write(string);
            }
             finally {
                writer.close();
            }
        }
        catch (IOException e){
            throw e;
        }
    }


    public static void main(String[] args) {
        try {
            filterFile("in", "E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\io1\\out", "! ,");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
