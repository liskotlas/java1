package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
//    public static void main(String[] args) {
//        double R = 6371.2;
//        System.out.println(volumeBallDouble(R));
//        System.out.println(volumeBallFloat((float)R));
//        System.out.println(calculateAccuracy(R));
//    }

    public static double volumeBallDouble(double radius){
        return (double)(4 / 3 * 3.14 * radius * radius * radius);
    }
    public static float volumeBallFloat(float radius){
        return (float)(4 / 3 * 3.14 * radius * radius * radius);
    }
    public static double calculateAccuracy(double radius){
        return  volumeBallFloat((float)radius)-(float)volumeBallDouble(radius);
    }
}
