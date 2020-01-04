package ru.progwards.java1.lessons.Training;

import java.util.ArrayDeque;

public class Java_13 {

    ArrayDeque<Integer> array2queue(int[] a){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int x : a){
            arrayDeque.add(x);
        }
        return arrayDeque;
    }

    int sumLastAndFirst(ArrayDeque<Integer> deque){
        if (deque.isEmpty()){
            return 0;
        }
        return deque.peekFirst() + deque.peekLast();
    }


    public static void main(String[] args) {

    }
}
