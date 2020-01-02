package ru.progwards.java1.lessons.sets;

import java.util.Set;

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

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2){
        Set<Integer>res1 = set1;
        Set<Integer>res2 = set2;
        res1.removeAll(set2);
        res2.removeAll(set1);
        res1.addAll(res2);
        return res1;
    }
}
