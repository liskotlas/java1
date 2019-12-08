package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    int number;

    public IntInteger(int number) {
        this.number = (int) number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public AbsInteger newNumber(String strNum) {
        return new IntInteger(Integer.parseInt(strNum));
    }
}
