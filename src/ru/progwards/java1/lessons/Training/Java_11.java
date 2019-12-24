package ru.progwards.java1.lessons.Training;

import java.util.*;
import java.util.Collections;



public class Java_11 {

    public List<Integer> listAction(List<Integer> list) {
        list.remove(Collections.min(list));
        list.add(0, list.size());
        list.add(2, Collections.max(list));
        return list;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> out = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo((int) res / 100) < 0) {
                out.add(list.get(i));
                list.remove(i);
                --i;
            }
        }
        return out;
    }

    public static void iterator3(ListIterator<Integer> iterator) {
        while (iterator.hasNext()) {
            if (iterator.next() % 3 == 0) {
                iterator.set(iterator.previousIndex());
            }
        }
    }

    public static void main(String[] args) {
//        List<Integer> linkedList = new LinkedList();
//        for (int i = 0; i < 5; i++)
//            linkedList.add(i);
//
//        for (ListIterator<Integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
//            Integer n = listIterator.next();
//            if (n % 2 != 0)
//                listIterator.remove();
//            else
//                listIterator.add(n * 2);
//        }
//
//            System.out.println(linkedList);
//        }

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 201; i+=10) {
            arrayList.add(i);
        }
        ListIterator<Integer> listIterator = arrayList.listIterator();
        System.out.println(arrayList);
        iterator3(listIterator);
        System.out.println(arrayList);


    }
}


