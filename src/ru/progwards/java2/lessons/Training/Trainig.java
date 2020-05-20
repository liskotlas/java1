package ru.progwards.java2.lessons.Training;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class Trainig {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2020, Month.JANUARY, 1, 12, 0, 10);
        LocalDateTime localDateTime1 = LocalDateTime.now();
        String time = localDateTime.toString();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-ddThh:mm:ss");
//        LocalDateTime localDateTime2 = LocalDateTime.parse(time, dateTimeFormatter);
//        System.out.println(localDateTime2.toString());
        String s = "2020-02-23 21:32:00";
//        TemporalAccessor f = dateTimeFormatter.parse("yyyy-MM-dd hh:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        LocalDateTime date = LocalDateTime.parse(s, formatter);
        System.out.println(date);


    }


}
