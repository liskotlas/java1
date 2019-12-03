package ru.progwards.java1.lessons.interfaces2;

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

     public int compareTo(Number num) {
        return Double.compare(Double.parseDouble(this.toString()), Double.parseDouble(num.toString()));
    }

    @Override
        public String toString() {
            return ((Double)dblNum).toString();
        }
}