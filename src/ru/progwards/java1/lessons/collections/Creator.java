package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Creator {
    public static Collection<Integer> fillEven(int n) {
        List<Integer> integerCollections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integerCollections.add((i + 1) * 2);
        }
        return integerCollections;
    }

    public static Collection<Integer> fillOdd(int n) {
        List<Integer> integerCollections = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            integerCollections.add(i * 2 - 1);
        }
        return integerCollections;
    }

    public static Collection<Integer> fill3(int n) {
        List<Integer> integerCollections = new ArrayList<>();
        for (int i = 0; i < n * 3; i += 3) {
            integerCollections.add(i, i);
            integerCollections.add(i+1, (i+1)*(i+1));
            integerCollections.add(i+2, (i+2)*(i+2)*(i+2));
        }
        return integerCollections;
    }


    public static void main(String[] args) {
        System.out.println(fill3(10));
    }
}
