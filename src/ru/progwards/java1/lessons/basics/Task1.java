package ru.progwards.java1.lessons.basics;

public class Task1 {
//    public static void main(String[] args) {
//        System.out.println(reverseDigits(123));
//    }
        public static int reverseDigits(int number){
            int mirror = 0;
            mirror = mirror * 10 + (number % 10);
            number /= 10;
            mirror = mirror * 10 + (number % 10);
            number /= 10;
            mirror = mirror * 10 + (number % 10);
            number /= 10;
            return mirror;

        }
}
