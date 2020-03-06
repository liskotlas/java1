package ru.progwards.java1.lessons.Training;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class Java_17 {

    String swapWords(String sentance) {

        String temp = "";
        String result = "";

        StringTokenizer tokenizer = new StringTokenizer(sentance, " .,-!\n");

        for (int f = 1; tokenizer.hasMoreTokens(); f++) {

            if (f % 2 == 0) {
                result += tokenizer.nextToken() + " " + temp + " ";
                temp = "";
            } else {
                temp = tokenizer.nextToken();
            }
        }

        return result.trim();
    }





    public static void main(String[] args) {

        System.out.println(new Java_17().swapWords("Слово - серебро, молчание - золото! Точно"));
        System.out.format("|%04d|%#x|%2.1f|", 2, 15, 3.25);
    }
}


class Person2 {
    public String name;
    public Date birth;
    public double salary;

    Person2(String name, Date birth, double salary) {
        this.name = name;
        this.birth = birth;
        this. salary = salary;
    }

    void printPersons(Person2[] persons){

        for (Person2 persona : persons){
            System.out.format(new Locale("ru"),"|%-10s|%2$td/%2$tm/%2$tY|%3$,10.2f|\n", persona.name, persona.birth, persona.salary);
        }
    }

    public static void main(String[] args) throws ParseException {
        String date = "01.01.1970";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
        Date date1 = format.parse(date);
//        System.out.format("%1$td/%1$tm/%1$tY", new Date());
        Person2 Vasya = new Person2("Вася", date1, 200000.00);

        Person2[] person2s = new Person2[]{Vasya};
        Vasya.printPersons(person2s);
    }
}