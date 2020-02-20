package ru.progwards.java1.lessons.Training;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class Java_2_0 {

    int[] subArray(int[] array, int from, int to) {
        if (from < 0 || to >= array.length || from > to) {
            return null;
        }
        int[] result = new int[to - from + 1];
        int f = 0;
        for (int i = from; i <= to; i++) {
            result[f] = array[i];
            f++;
        }
        return result;
    }

    static int factorial (int n){
        if (n == 0) {return 1;}
        int fn = 1;
        for (int i = 1; i <= n; i++){
            fn *= i;
        }
        return fn;
    }

    public int arrayMax(int[] a){
        if(a.length == 0){
            return 0;
        }
        Arrays.sort(a);
        return a[a.length-1];
    }




    public static void main(String[] args) {

        int[] array = {12, 4, 33, 17, 98, 0};
        System.out.println(new Java_2_0().subArray(array, 4, 2));
        byte value = 0b00010100;
        int i = (int) value & 0b00000001;
        double y = 5.234 % 2;
        System.out.println(factorial(9));
        BigDecimal bigDec1 = BigDecimal.valueOf(10);
        BigDecimal bigDec2 = BigDecimal.valueOf(3);
        BigDecimal result = bigDec1.divide(bigDec2);

        System.out.println(result);
    }
}
