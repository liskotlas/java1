package ru.progwards.java1.lessons.Training;

import org.apache.logging.log4j.core.util.ArrayUtils;

import java.util.Arrays;

public class Training {

    public static void main(String[] args) {

        String inFileName = "Привет, мы здесь!! !! ! !!";
//        String outFileName = "";
        String filter = ", !";

        char[] a = inFileName.toCharArray();
        char[] b = filter.toCharArray();
        String string = "";
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
        System.out.println(Arrays.toString(a));
        System.out.println(string);
    }
}

