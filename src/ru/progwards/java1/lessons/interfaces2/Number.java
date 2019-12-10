package ru.progwards.java1.lessons.interfaces2;

public abstract class Number implements Comparable<Number>{
    Number(){
    }

    @Override
    public int compareTo(Number num) {
        return 0;
    }

    public Number mul (Number num) {
        return null;
    }

    public Number div (Number num) {
        return null;
    }

    public Number newNumber(String strNum) {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}


