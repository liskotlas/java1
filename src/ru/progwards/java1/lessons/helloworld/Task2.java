package ru.progwards.java1.lessons.helloworld;


public class Task2 {
    public static void subtraction(int x, int y) {
        int z;
        z = x + y;
        System.out.println("Вызвана функция subtraction() с параметрами x = " + x + ", y = " + y);
        System.out.println("Результат z = " + z);
    }

    public static void main(String[] args) {
        subtraction(89, 95);
    }
}