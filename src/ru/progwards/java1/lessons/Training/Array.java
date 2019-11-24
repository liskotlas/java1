package ru.progwards.java1.lessons.Training;

public class Array {
    public static int sumArrayItems(int[] a){
        int result = 0;
        for (int i=0; i < a.length; i++){
            result += a [i];
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {12};
        System.out.println(Array.sumArrayItems (arr));
    }
}
