package ru.progwards.java1.lessons.Training;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class Java_15 {

    Date createDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1986, 1, 28);
        return calendar.getTime();
    }

    Instant createInstant(){
//        LocalDateTime localDateTime = LocalDateTime.of(2020, 01, 01, 00, 00);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2020, 01, 01, 15, 00, 00, 00, ZoneId.of("Europe/Moscow"));
        return Instant.ofEpochSecond((zonedDateTime.toEpochSecond())).plusNanos(1);
    }

//    Напишите метод, с сигнатурой ZonedDateTime parseZDT(String str), который возвращает ZonedDateTime, парся строку вида "01.01.2020 16:27:14.444 +0300 Moscow Standard Time"
    ZonedDateTime parseZDT(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS zzzz");
        return ZonedDateTime.from(formatter.parse(str));
    }

//    "dd.MM.yyyy HH:mm:ss.S"
//    "'От''езд' - EEEE dd MMMM 'в' ha"
//    "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'"

    public static void main(String[] args) {


    }
}