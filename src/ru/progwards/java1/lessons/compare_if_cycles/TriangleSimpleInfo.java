package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {

    public static int maxSide(int a, int b, int c){
        if (a >= b && a >= c){
            return a;
        }
        if (b >= a && b >= c){
            return b;
        }
        if (c >= a && c >= b){
            return c;
        }
        return 0;
    }

    public static int minSide(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        }
        if (b < a && b < c) {
            return b;
        }
        if (c < a && c < b) {
            return c;
        }
        return 0;
    }
    public static boolean isEquilateralTriangle(int a, int b, int c){
        if (a == b && b == c){
            return true;
        }
        else {
            return false;
        }
    }
}
