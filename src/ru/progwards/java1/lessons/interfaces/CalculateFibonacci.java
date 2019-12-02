package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    static CacheInfo lastFibo;

    static class CacheInfo {
        int n;
        int fibo;

        CacheInfo (int fibo){
            this.fibo = fibo;
            ;
        }
    }
    public static int fiboNumber(int n) {
        int r = 1;
        int x = 0;
        int z = 0;
        for (int i = 1; i <= n; i++) {
            z = r + x;
            x = r;
            r = z;
            if (i == 1) {
                x = 0;
            }
            if (i != n) {
                lastFibo = new CacheInfo(r);
            }
            }
        return r;
    }
    }

