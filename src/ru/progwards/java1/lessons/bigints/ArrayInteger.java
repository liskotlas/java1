package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;

//import static java.lang.Math.pow;

public class ArrayInteger {
    byte[] digits;

    ArrayInteger(int n) {
        digits = new byte[n];
    }

    void fromInt(BigInteger value) {
        BigInteger tmp = value;
        int size = value.toString().length();
        for (int i = 0; i < size; i++) {
            this.digits[i] = (value.mod(BigInteger.valueOf(10))).byteValue();
            value = value.divide(BigInteger.valueOf(10));
        }
    }

    BigInteger toInt() {
        String s = "";
        for (int i = this.digits.length - 1; i >= 0; i--) {
            s += digits[i] + "";
        }

        BigInteger result = new BigInteger(s);
//        BigInteger result = new BigInteger(this.digits);
        return result;
    }

    boolean add(ArrayInteger num) {

        if (num.digits.length > this.digits.length) {
            Arrays.fill(this.digits, (byte) 0);
            return false;
        }

        BigInteger result1 = BigInteger.valueOf(0);
        BigInteger result2 = BigInteger.valueOf(0);
        BigInteger result = BigInteger.valueOf(0);


        for (int i = 0; i < this.digits.length; i++) {
            if (i < num.digits.length) {
                result1 = BigInteger.valueOf(this.digits[i]).add(BigInteger.valueOf(num.digits[i]));
            } else {
                result1 = BigInteger.valueOf(this.digits[i]);
            }
            result2 = result1.multiply(BigInteger.valueOf(10).pow(i));
            result = result1.add(result2);
        }
        this.fromInt(result);
        return true;
    }



        public static void main (String[]args){
            ArrayInteger num = new ArrayInteger(10);
            num.fromInt(BigInteger.valueOf(1234567890));


        }
    }


