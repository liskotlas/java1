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
        return new DoubleNumber(n1.dblNum * n2.dblNum);
    }

    @Override
    public Number div(Number n1, Number n2) {
        return new DoubleNumber(n1.dblNum / n2.dblNum);
    }
}