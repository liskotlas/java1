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
                start = LocalDateTime.parse(strStart, formatter).atZone(ZoneId.systemDefault());
            case LONG:
                DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                start = LocalDateTime.parse(strStart, formatter1).atZone(ZoneId.systemDefault());
            case FULL:
                DateTimeFormatter formatter2 = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                start = ZonedDateTime.parse(strStart, formatter2);
        }
    }

    public void setDuration(Duration duration){
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration){
        duration = Duration.between(expiration, start);
    }

    public void setDuration(int months, int days, int hours){
        duration = Duration.from(Period.ofMonths(months)).plusDays(days).plusHours(hours);
    }

    public void setDuration(String strDuration, FormatStyle style){
        switch (style){
            case SHORT:
                duration = Duration.ofMillis(Long.valueOf(strDuration));
            case LONG:
                LocalDateTime time = LocalDateTime.parse(strDuration, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                duration = Duration.parse(time.toString());
            case FULL:
                duration = Duration.parse(strDuration);
        }
    }

    public boolean checkValid(ZonedDateTime dateTime){
        if (dateTime.compareTo(start) >=0 && dateTime.compareTo(start.plusSeconds(duration.getSeconds())) <=0){
            return true;
        }
        return false;
    }
}
