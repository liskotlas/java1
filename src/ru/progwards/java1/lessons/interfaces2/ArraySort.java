package ru.progwards.java1.lessons.interfaces2;


public class ArraySort implements java.lang.Comparable {
    public static void sort(Comparable<Number>[] a){
        Comparable<Number> tmp;
//    public void sort (Animal[] a){
        for (int f = 0; f < a.length; f++){
        String s =a[f].toString();
        for (int i = f + 1; i < a.length; i++){
//                if (a [f] > a [i]){
            if (a[f].compareTo ((Number)a[i]) < 0) {
                tmp = a [f];
                a[f] = a[i];
                a [i] = tmp;
            }
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}