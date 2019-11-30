package ru.progwards.java1.lessons.abstractnum;

public class DoubleNumber extends Number {
    double dblNum;

    public DoubleNumber (Double dblNum){
        this.dblNum = dblNum;
    }

    @Override
    public Number newNumber(String strNum){
        return new DoubleNumber(Double.parseDouble(strNum));

    }

    @Override
    public Number mul(Number num) {
        Double n = dblNum * Double.parseDouble(num.toString());
        return newNumber(n.toString());
    }

    @Override
    public Number div(Number num) {
        Double n = dblNum / Double.parseDouble(num.toString());
        return newNumber(n.toString());
    }

    @Override
        public String toString() {
            return ((Double)dblNum).toString();
        }
}