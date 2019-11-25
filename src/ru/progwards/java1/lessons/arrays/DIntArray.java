package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int [] a;
//

    public DIntArray (){

    }

    public void add(int num){
        int [] b;
        b = Arrays.copyOf(a, a.length+1);
        b [a.length + 1] = num;
        int [] a = Arrays.copyOf(b, b.length);
    }

    public void atInsert(int pos, int num){
        int [] b;
        b = new int [a.length + 1];
        System.arraycopy(a, 0, b, 0, pos - 1);
        b [pos] = num;
        System.arraycopy(a, pos, b, pos+1, a.length - pos);
        int a[] = Arrays.copyOf(b, b.length);
    }

    public void atDelete(int pos){
        int b[];
        b = new int [a.length -1];
        System.arraycopy(a, 0, b, 0, pos - 1);
        System.arraycopy(a, pos+1, b, pos, a.length - pos - 1);
        int a[] = Arrays.copyOf(b, b.length);
    }

    public int at(int pos){
        return a [pos];
    }
}
