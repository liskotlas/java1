package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    byte number;


    ByteInteger(byte number) {
        this.number = (byte) number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public AbsInteger newNumber(String strNum) {
        return new ByteInteger((byte) Integer.parseInt(strNum));
    }
}
