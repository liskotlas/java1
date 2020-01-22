package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Insurance {

    private ZonedDateTime start;
    private Duration duration =null;


    public static enum FormatStyle {SHORT, LONG, FULL}{
        }




    public Insurance(ZonedDateTime start){
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style){
        switch (style){
            case SHORT:
                DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate start2 = LocalDate.parse(strStart, formatter);
                LocalTime time = LocalTime.of(0,0);
                LocalDateTime dateTime = LocalDateTime.of(start2, time);

                break;
            case LONG:
                DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                start = LocalDateTime.parse(strStart, formatter1).atZone(ZoneId.systemDefault());
                break;
            case FULL:
                DateTimeFormatter formatter2 = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                start = ZonedDateTime.parse(strStart, formatter2);
                break;
        }
    }

    public void setDuration(Duration duration){
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration){
        duration = Duration.between(expiration, start);
    }

    public void setDuration(int months, int days, int hours){
        duration = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusMonths(months).plusDays(days).plusHours(hours));
    }

//    public void setDuration(int mons, int days, int hrs) {
//        ZonedDateTime ldt = start == null ? ZonedDateTime.now() : start;
//        ldt = ldt.plusMonths(mons).plusDays(days).plusHours(hrs);
//        duration = Duration.between(start, ldt);
//    }

    public void setDuration(String strDuration, FormatStyle style){
        switch (style){
            case SHORT:
                duration = Duration.ofMillis(Integer.parseInt(strDuration));
                break;
            case LONG:
                LocalDateTime time = LocalDateTime.parse("0000-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                duration = Duration.between(time, LocalDateTime.parse(strDuration, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                break;
            case FULL:
                duration = Duration.parse(strDuration);
        }
    }

//    public boolean checkValid(ZonedDateTime dateTime){
//
//        if (dateTime.isAfter(start)&& dateTime.isBefore(start.plusSeconds(duration.toSeconds()))){
//            return true;
//        }
//        return false;
//    }

    public boolean checkValid(ZonedDateTime dateTime) {
        if (duration == null) return dateTime.isAfter(start);
        ZonedDateTime end = start.plusHours(duration.toHours());
        return dateTime.isAfter(start) && dateTime.isBefore(end);
    }

    public String toString(){
        if (checkValid(ZonedDateTime.now(ZoneId.systemDefault())) == true){
            return "Insurance issued on " + start +  " is valid";
        }
        return "Insurance issued on " + start +  " is not valid";
    }

//    public static void main(String[] args) {
//        Insurance insurance = new Insurance(ZonedDateTime.now(ZoneId.systemDefault()));
//        insurance.setDuration(1,9,0);
//        System.out.println(insurance.checkValid(ZonedDateTime.now(ZoneId.systemDefault()).plusDays(35)));
//    }

    public static void main(String[] args) {
        LocalDateTime date0 = LocalDateTime.parse("0000-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime date1 = LocalDateTime.parse("0000-06-03T10:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME).plusMonths(1).plusDays(1);
        Duration duration = Duration.between(date0, date1);
        System.out.println(date0);
        System.out.println(date1);
        System.out.println(duration);
    }
}


