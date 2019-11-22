package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    public static int sumBits(byte value) {
        int result = 0;
        for (int i = 0; i <= 7; i++) {
            result += value >> i & 0b00000001;
        }
        return result;
    }

    public static void main(String[] args) {
        byte b = 0b1110100;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(sumBits(b));

    }
}
