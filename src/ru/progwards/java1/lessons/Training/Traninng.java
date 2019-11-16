package ru.progwards.java1.lessons.Training;

import java.sql.SQLOutput;

public class Traninng {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    static long factorial(long n){
        long f = 1;
        for (long i = 1; i <= n; i++){
            f *= i;
        }
        return f;
    }
}
