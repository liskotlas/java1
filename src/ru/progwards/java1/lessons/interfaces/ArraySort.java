package ru.progwards.java1.lessons.interfaces;

import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;

public class ArraySort implements Comparable{
    int tmp;

    public void sort (Animal[] a){
        Animal x, y;
        int tmp;

           for (int f = 0; f < a.length; f++){
            x = a [f];
            for (int i = f + 1; i < a.length; i++){
//                new Animal[] = a[i];
//                if (a [f] > a [i]){
                if (Comparable (x) > 1){
//                    tmp = a [f];
                    a [f] = a [i];
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

    @Override
    public int Comparable(Animal x) {
//        if (x > Animal(Animal(););)


        return 0;
    }
}
