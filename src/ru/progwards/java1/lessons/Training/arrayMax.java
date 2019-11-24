package ru.progwards.java1.lessons.Training;

import java.util.Arrays;

public class arrayMax {
    public int arrayMax(int[] a){
        Arrays.sort(a);
        if (a.length == 0){
            return 0;
        }
        else {
            return (a[a.length - 1]);
        }
    }
}
