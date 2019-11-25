package ru.progwards.java1.lessons.abstractnum;

public class DoubleNumber extends Number {
    double dblNum ;

    public DoubleNumber (Double dblNum){
        this.dblNum = dblNum;
    }

    @Override
    public Number newNumber(String strNum){
        double dblNum = Double.valueOf(strNum);
        return new DoubleNumber(dblNum);
    }

    @Override
    public java.lang.Number mul(Number n1, Number n2) {
        double dblNumN1 = Double.valueOf(String.valueOf(n1));
        double dblNumN2 = Double.valueOf(String.valueOf(n2));
        return (dblNumN1 * dblNumN2);
    }

    @Override
    public java.lang.Number div(Number n1, Number n2) {
        double dblNumN1 = Double.valueOf(String.valueOf(n1));
        double dblNumN2 = Double.valueOf(String.valueOf(n2));
        return (dblNumN1 / dblNumN2);
    }
}