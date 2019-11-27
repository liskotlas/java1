package ru.progwards.java1.lessons.abstractnum;

public class IntNumber extends Number {
    int intNum ;

    public IntNumber (int IntNum){
        this.intNum = IntNum;
    }

    @Override
    public Number newNumber(String strNum){
        int intNum = Integer.valueOf(strNum);
        return new IntNumber(intNum);
    }
    @Override
    public Number mul(Number n1, Number n2) {
//        return (Integer.valueOf(String.valueOf(n1)) * Integer.valueOf(String.valueOf(n2)));
        return Integer.parseInt(n1.toString());
    }

    @Override
    public Number div(Number n1, Number n2){
        return (Integer.valueOf(String.valueOf(n1))) / (Integer.valueOf(String.valueOf(n2)))  ;

    }
}
