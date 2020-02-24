package ru.progwards.java1.lessons.queues;

import java.time.LocalDateTime;
import java.util.*;

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

        Collection<Integer> integerCollection = new ArrayDeque<>();
        while (!data.isEmpty()) {
            ((ArrayDeque<Integer>) integerCollection).offer(Collections.min(data));
            data.remove(Collections.min(data));
        }
        data.addAll(integerCollection);
    }

    static void collSort(Collection<Integer> data) {

        ArrayList<Integer> list = new ArrayList<>(data);
        Collections.sort(list);
        data.clear();
        data.addAll(list);
    }

    public static Collection<String> compareSort() {

        ArrayList<String> result = new ArrayList<>();
//        ArrayList<Sorted> resultSorted = new ArrayList<>();
        TreeSet<Sorted> resultSorted = new TreeSet<>();

        Collection<Integer> integerCollection = new ArrayList<Integer>();
        for (int i = 0; i < 5_000; i++) {
            integerCollection.add(i);
        }

        long timeMy = System.currentTimeMillis();
        mySort(integerCollection);
        timeMy = System.currentTimeMillis() - timeMy;
        resultSorted.add(new Sorted("mySort", timeMy));

        long timeMin = System.currentTimeMillis();
        minSort(integerCollection);
        timeMin = System.currentTimeMillis() - timeMin;
        resultSorted.add(new Sorted("minSort", timeMin));

        long timeSort = System.currentTimeMillis();
        collSort(integerCollection);
        timeSort = System.currentTimeMillis() - timeSort;
        resultSorted.add(new Sorted("collSort", timeSort));
        System.out.println("myTime = " + timeMy);
        System.out.println("MinTime = " + timeMin);
        System.out.println("CollTime = " + timeSort);

        for(Sorted s : resultSorted){
            System.out.println(s.name + "   -   " + s.time);
            result.add(s.name);
        }
//        if (timeMin < timeMy && timeMin < timeSort && timeMy < timeSort) {
//            result.add("minSort");
//            result.add("mySort");
//            result.add("collSort");
//        }
//        if (timeMin < timeMy && timeMin < timeSort && timeMy > timeSort) {
//            result.add("minSort");
//            result.add("collSort");
//            result.add("mySort");
//        }
//        if (timeMin > timeMy && timeMin > timeSort && timeMy > timeSort) {
//            result.add("collSort");
//            result.add("mySort");
//            result.add("minSort");
//        }
//        if (timeMin < timeMy && timeMin > timeSort && timeMy > timeSort) {
//            result.add("collSort");
//            result.add("minSort");
//            result.add("mySort");
//        }
//        if (timeMin > timeMy && timeMin > timeSort && timeMy < timeSort) {
//            result.add("mySort");
//            result.add("collSort");
//            result.add("minSort");
//        }
//        if (timeMin > timeMy && timeMin < timeSort && timeMy < timeSort) {
//            result.add("mySort");
//            result.add("minSort");
//            result.add("collSort");
//        }
        return result;
    }

    public static class Sorted implements Comparable<Sorted>{
        long time;
        String name;

        public Sorted(String name, long time){
            this.time = time;
            this.name = name;
        }

        @Override
        public int compareTo(Sorted o) {
            if(this.time < o.time) {
                return -1;
            }
            if(this.time > o.time){
                return 1;
            }else{
                return this.name.compareTo(o.name);
            }

        }
    }

    public static void main(String[] args) {
//        Collection<Integer> integerCollection = new ArrayList<>(List.of(3, 7, 4, 2, 5, 6));
//        System.out.println(integerCollection);
//        minSort(integerCollection);
//        System.out.println(integerCollection);
        System.out.println(compareSort());
    }
}


