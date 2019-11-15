package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static void main(String[] args) {
        for (int f = 1; f < 16; f++) {
           System.out.println(fiboNumber(f));
        }
        for (int i = 1; i <= 100; i++){
            for (int d = 1; d <= 100; d++){
                if (isGoldenTriangle(i, i, d)){
                    System.out.println("Треугольник: a = " + i + " b = " + i + " c = " + d);
                }
            }
        }
    }
    public static boolean containsDigit(int number, int digit) {
        while (number > 0) {
            if (number >= 10 && number % 10 == digit) {
                return true;
            }
            if (number < 10 && number == digit) {
                return true;
            }
            number /= 10;
        }
        return false;
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
        }
        return r;
    }

    public static boolean isGoldenTriangle(int a, int b, int c){
        if (a == b && (float) a / (float) c > 1.61703 && (float) a / (float) c < 1.61903){
            return true;
        }
        if (a == c && a / b > 1.61703 && a/b < 1.61903){
            return true;
        }
        if (c == b && c / a > 1.61703 && c/a < 1.61903){
            return true;
        }
        return false;

    }
}