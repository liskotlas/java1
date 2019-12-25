package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

public class Finder {
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {

        List<Integer> arrayList = new ArrayList<Integer>(numbers);
        Collection<Integer> out = new ArrayList();

        int res;
        int i1 = 0;
        int i2 = 0;

        if (arrayList.size() > 1) {
            res = arrayList.get(0) + arrayList.get(1);
        } else {
            out.add(0);
            out.add(0);
            return out;
        }

        for (int i = 1; i < arrayList.size() - 1; i++) {

            if (res > arrayList.get(i) + arrayList.get(i + 1)) {
                res = arrayList.get(i) + arrayList.get(i + 1);
                i1 = i;
                i2 = i + 1;
            }
        }
        out.add(i1);
        out.add(i2);
//        System.out.println(arrayList.get(i1)  + " и " + arrayList.get(i2));
        return out;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {

        List<Integer> arrayList = new ArrayList<>(numbers);
        Collection<Integer> out = new ArrayList<Integer>();

        int res;

        if (arrayList.size() > 2) {
            res = arrayList.get(1);
        } else {
            out.add(0);
            return out;
        }

        for (int i = 1; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i) > arrayList.get(i - 1) && arrayList.get(i) > arrayList.get(i + 1)) {
                out.add(arrayList.get(i));
            }
        }
        return out;
    }

    public static boolean findSequence(Collection<Integer> numbers) {

        for (int i = 1; i <= numbers.size(); i++) {
            if (numbers.contains(i)) {
                continue;
            } else return false;
        }
        return true;
    }

    public static String findSimilar(Collection<String> names) {
        Collection<String> namesIn = new ArrayList<>(names);
        Collection<String> strings = new ArrayList<>();
        int res = 1;
        int res1 = 0;
        String out = "";
        for (int i = 0; i < namesIn.size(); i++) {
            if (strings.contains(((ArrayList<String>) namesIn).get(i))) {
                continue;
            }
            for (int f = i + 1; f < namesIn.size(); f++) {
                if (((ArrayList<String>) namesIn).get(i).compareTo(((ArrayList<String>) namesIn).get(f)) == 0) {
                    ++res;
                }
            }
            if (res > res1) {
                out = ((ArrayList<String>) namesIn).get(i);
                res1 = res;
            }
            strings.add(((ArrayList<String>) namesIn).get(i));
            res = 1;
        }

        return out + ":" + res1;
    }

    public static void main(String[] args) {
        Finder finder = new Finder();
        Collection<String> collection = new ArrayList<>();
        collection.add("Петя");
        collection.add("Вася");
        collection.add("Петя");
        collection.add("Вася");
        collection.add("Вася");
        collection.add("Миша");
        collection.add("Петя");
        collection.add("Вася");
        collection.add("Миша");
        collection.add("Вася");
        collection.add("Петя");
        collection.add("Миша");
        collection.add("Петя");


        System.out.println(findSimilar(collection));


    }
}

