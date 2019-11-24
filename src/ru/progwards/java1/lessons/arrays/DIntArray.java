package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int [] a;
    private int [] b;

    public DIntArray (){

    }

    public void add(int num){
        Arrays.copyOf(a, a.length+1);
        a [a.length + 1] = num;
    }

    public void atInsert(int pos, int num){
        b = new int [a.length + 1];
        System.arraycopy(a, 0, b, 0, pos - 1);
        b [pos] = num;
        System.arraycopy(a, pos, b, pos+1, a.length - pos);
    }

    public void atDelete(int pos){
        b = new int [a.length -1];
        System.arraycopy(a, 0, b, 0, pos - 1);
        System.arraycopy(a, pos+1, b, pos, a.length - pos - 1);
    }

    public int at(int pos){
        return b [pos];
    }

     public static void main(String[] args) {
        int [] a = {1234567890};
        ;

    }
}
