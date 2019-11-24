package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {

    int N;
    private Boolean[] sieve;

    public Eratosthenes(int N) {
        sieve = new Boolean[N];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift() {
        for (int f = 2; f <= sieve.length; f++) {
            for (int i2 = f; i2 <= sieve.length; ++i2) {
                if (f * i2 < sieve.length) {
                    sieve[f * i2] = false;
                }
            }
        }
    }

    public boolean isSimple(int n){
        return sieve [n];
    }

        public static void main (String[]args){
            new Eratosthenes(30);
        }
}