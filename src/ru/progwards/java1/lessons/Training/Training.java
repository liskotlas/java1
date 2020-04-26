package ru.progwards.java1.lessons.Training;


public class Training {

    public static void main(String[] args) {

        String s = "\"ООО Котласгазсервис\"";
        System.out.println(s);
        String s2 = s.replaceAll("ООО", " ").replaceAll("\"", " ").trim();
        System.out.println(s.contains(s2));
    }
}