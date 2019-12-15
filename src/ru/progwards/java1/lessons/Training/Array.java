package ru.progwards.java1.lessons.Training;

import java.util.Arrays;

public class Array {
    public static int sumArrayItems(int[] a){
        int result = 0;
        for (int i=0; i < a.length; i++){
            result += a [i];
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {12};
        char [] c = new char[]{'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(c));
    }
}
