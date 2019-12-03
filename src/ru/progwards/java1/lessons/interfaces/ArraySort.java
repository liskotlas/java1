package ru.progwards.java1.lessons.interfaces;

import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;

public class ArraySort{
    int tmp;
//    public static void sort(Comparable<Animal>[] a){
    public void sort (Animal[] a){

           for (int f = 0; f < a.length; f++){
            String s =a[f].toString();
            for (int i = f + 1; i < a.length; i++){
//                if (a [f] > a [i]){
                if (a[f].compareTo ((Animal)a[i]) < 0) {
//                    tmp = a [f];
                    a[f] = a[i];
//                    a [i] = tmp;
                }
                }
            }
        }


    public static void main(String[] args) {
        int [] a = {2,4,3,6,5,7,5,8,1,0};
//        sort(a);
        System.out.println(Arrays.toString(a));
    }


}