package ru.progwards.java2.lessons.generics;

public class ArraySort {

    public static <T extends Comparable> void sort(T[] a) {

        T tmp;
        for (int f = 0; f < a.length; f++) {
            for (int i = f + 1; i < a.length; i++) {
                if (a[f].compareTo(a[i]) > 1) {
                    tmp = a[f];
                    a[f] = a[i];
                    a[i] = tmp;
                }
            }
        }

    }
}
