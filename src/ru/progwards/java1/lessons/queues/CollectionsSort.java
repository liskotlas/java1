package ru.progwards.java1.lessons.queues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        List<Integer> integerList = new ArrayList<>(data);

        for (int a = 0; a < integerList.size(); a++) {
            for (int b = 0; b < integerList.size(); b++) {
                if (integerList.get(b) > integerList.get(a)) {
                    Collections.swap(integerList, a, b);
                }
            }
        }
        data.clear();
        data.addAll(integerList);
    }

    public static void minSort(Collection<Integer> data) {


    }

    public static void main(String[] args) {
        Collection<Integer> integerCollection = new ArrayList<>(List.of(3, 7, 4, 2, 5, 6));
        System.out.println(integerCollection);
        mySort(integerCollection);
        System.out.println(integerCollection);
    }
}


