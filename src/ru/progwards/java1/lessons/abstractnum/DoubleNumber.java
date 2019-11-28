package ru.progwards.java1.lessons.abstractnum;

public class DoubleNumber extends Number {
//    double dblNum ;

    public DoubleNumber (Double dblNum){
        this.dblNum = dblNum;
    }

    @Override
    public Number newNumber(String strNum){
        return new DoubleNumber(Double.parseDouble(strNum));
    }

    @Override
    public Number mul(Number n1, Number n2) {
        double dblNumN1 = Double.parseDouble(n1.toString());
        double dblNumN2 = Double.parseDouble(n2.toString());
//        double dblNumN1 = Double.valueOf(String.valueOf(n1));
//        double dblNumN2 = Double.valueOf(String.valueOf(n2));
        return (n1);
    }

    @Override
    public Number div(Number n1, Number n2) {
        double dblNumN1 = Double.valueOf(String.valueOf(n1));
        double dblNumN2 = Double.valueOf(String.valueOf(n2));
        dblNum = dblNumN1 / dblNumN2;

        return n1;
    }
}