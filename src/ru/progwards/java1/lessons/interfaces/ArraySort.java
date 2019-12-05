package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort{
    public static void sort(Comparable<Animal>[] a){
        Comparable<Animal> tmp;
//    public void sort (Animal[] a){
        for (int f = 0; f < a.length; f++){
        String s =a[f].toString();
        for (int i = f + 1; i < a.length; i++){
//                if (a [f] > a [i]){
            if (a[f].compareTo ((Animal)a[i]) < 0) {
                tmp = a [f];
                a[f] = a[i];
                a [i] = tmp;
            }
            }
        }
    }
}