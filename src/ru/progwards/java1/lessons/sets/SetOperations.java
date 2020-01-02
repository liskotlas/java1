package ru.progwards.java1.lessons.sets;

import java.util.Set;
import java.util.TreeSet;

public class SetOperations {

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
        Set <Integer> result = set1;
        result.addAll(set2);
        return result;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        Set <Integer> result = set1;
        result.retainAll(set2);
        return result;
    }

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2){
        Set <Integer> result = set1;
        result.removeAll(set2);
        return result;

    }

    public static Set<Integer> symDifference(final Set<Integer> set1, final Set<Integer> set2){
        Set<Integer>res1 =set1;
        Set<Integer>res2 = new TreeSet<>();
        for (Integer a: set2){
            res2.add(a);
        }

        res2.retainAll(set1);

        res1.addAll(set2);

        res1.removeAll(res2);
        return res1;
    }

    public static void main(String[] args) {
        Set <Integer> set1 = new TreeSet<>();
        Set <Integer> set2 = new TreeSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set1.add(6);
        set1.add(7);
        set1.add(9);
        set1.add(10);

        set2.add(1);
        set2.add(2);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);
        set2.add(9);
        set2.add(10);

        System.out.println(symDifference(set1, set2).toString());

    }
}
