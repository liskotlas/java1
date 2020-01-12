package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {

    private Map<Integer, BigDecimal> fiboCache = new HashMap<>();
    boolean cacheOn;
    private int n;

    public FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
    }

    private BigDecimal fibo(int n) {
        this.n = n;
        BigDecimal r = BigDecimal.valueOf(1);
        BigDecimal x = BigDecimal.valueOf(0);
        BigDecimal z;
        for (int i = 1; i <= n; i++) {
            z = r.add(x);
            x = r;
            r = z;
            if (i == 1) {
                x = BigDecimal.valueOf(0);
            }
        }
        return r;
    }

    public BigDecimal fiboNumber(int n) {
        if (cacheOn == true) {
            BigDecimal res = fibo(n);
            if (fiboCache != null && fiboCache.get(n) == res) {
                return fiboCache.get(n);
            } else {
                fiboCache.put(n, res);
                return res;
            }

        }
        return fibo(n);
    }

    public void clearCahe() {
        fiboCache.clear();
    }

    public static void test() {
        FiboMapCache fiboMapCacheOn = new FiboMapCache(true);
        FiboMapCache fiboMapCacheOff = new FiboMapCache(false);
        long cacheOff = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            fiboMapCacheOff.fiboNumber(i);
        }
        cacheOff = System.currentTimeMillis() - cacheOff;

        System.out.println(("fiboNumber cacheOn=false время выполнения " + cacheOff));

        long cacheOn = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            fiboMapCacheOn.fiboNumber(i);
        }
        cacheOn = System.currentTimeMillis() - cacheOn;

        System.out.println("fiboNumber cacheOn=true время выполнения " + cacheOn);
    }

    public static void main(String[] args) {
        test();


    }
}
