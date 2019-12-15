package ru.progwards.java1.lessons.Training;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Java_9_1 {
    public Integer sqr(Integer n) {
        try {
            return n * n;
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public String test(String filename) throws IOException {

        try {
            String s = filename.toString();
        }
            catch (Exception e) {
                throw new IOException("File not found");
        }
        return new String("File processing");
    }


}



