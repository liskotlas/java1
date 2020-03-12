package ru.progwards.java2.lessons.Training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java2_3<T> {

    public static <T> void swap(List<T> list, int x, int y) {

        T tmp;
        tmp = (T) list.get(x);
        list.set(x, list.get(y));
        list.set(y, tmp);

    }


    enum CompareResult {LESS, EQUAL, GREATER};

    public static <T extends Comparable> CompareResult compare (T one, T two){

        switch (one.compareTo(two)){

            case -1:
                return CompareResult.LESS;

            case 0:
                return CompareResult.EQUAL;

            default:
                return CompareResult.GREATER;
        }
    }

    public static <T> List from(T[] arr){

        ArrayList<T> list = new ArrayList<>();

        for (T element : arr){
            list.add(element);
        }

       return list;
    }

    public static void main(String[] args) {
//        String[] arr = new String[]{"1", "2", "3"};
//
//        new ArrayList<String> (Arrays.asList(arr)).forEach(System.out::println);

//        Integer a = Integer.parseInt(8 + "+" + 1);
       ;


    }
}
