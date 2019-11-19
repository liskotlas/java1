package ru.progwards.java1.lessons.abstractnum;

public class IntNumber extends Number {
    java.lang.Number intNum ;
    private Number n1;
    private Number n2;

    public IntNumber (int IntNum){
        this.intNum = IntNum;
    }

    @Override
    public Number newNumber(String strNum){
        int intNum = Integer.valueOf(strNum);
        return new IntNumber(intNum);
    }

    @Override
    public java.lang.Number mul(Number n1, Number n2) {
        int intN1 = Integer.valueOf(String.valueOf(n1));
        int intN2 = Integer.valueOf(String.valueOf(n2));
        return (intN1 * intN2);
    }

    @Override
    public java.lang.Number div(Number n1, Number n2){
        int intN1 = Integer.valueOf(String.valueOf(n1));
        int intN2 = Integer.valueOf(String.valueOf(n2));
        return intN1 / intN2;

    }

}
