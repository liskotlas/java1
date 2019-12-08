package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;

public class BigAlgebra {
    public static BigDecimal fastPow(BigDecimal num, int pow){
        BigDecimal res = new BigDecimal(1);
        for (int f = Integer.toBinaryString(pow).length()-1; f >= 0 ; f--){
            int s = pow >> f & 0b00000001;
            if (f>0 ){
                res = (res.multiply(num.pow(s))).pow(2);
            }
            else {
                res = res.multiply(num.pow(s));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fastPow(new BigDecimal(50), 5));

    }
}
