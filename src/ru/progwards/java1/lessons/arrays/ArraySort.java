package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {
    int tmp;

    public static void sort(int[] a){
        int tmp;
        for (int f = 0; f < a.length; f++){
            for (int i = f + 1; i < a.length; i++){
                if (a [f] > a [i]){
                    tmp = a [f];
                    a [f] = a [i];
                    a [i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {2,4,3,6,5,7,5,8,1,0};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
