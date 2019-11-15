package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static void main(String[] args) {
        double R = 6371.2;
        System.out.println(volumeBallDouble(R));
        System.out.println(volumeBallFloat((float)R));
        System.out.println(calculateAccuracy(R));
    }

    public static double volumeBallDouble(double radius){
        return 4.0 / 3.0 * 3.14 * radius * radius * radius;
    }
    public static float volumeBallFloat(float radius){
        return 4f / 3f * 3.14f * radius * radius * radius;
    }
    public static double calculateAccuracy(double radius){
        return  volumeBallFloat((float)radius)-volumeBallDouble(radius);
    }
}
