package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger{
    short number;

    public ShortInteger(short number) {
        this.number = (short) number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public AbsInteger newNumber(String strNum) {
        return new ShortInteger((short) Integer.parseInt(strNum));
    }
}
