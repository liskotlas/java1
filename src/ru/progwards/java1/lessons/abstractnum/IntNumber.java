package ru.progwards.java1.lessons.abstractnum;

public class IntNumber extends Number {
//    int intNum ;


    public IntNumber (int intNum){
        this.intNum = intNum;
    }

    @Override
    public Number newNumber(String strNum){
        return new IntNumber(Integer.parseInt(strNum));

    }
    @Override
    public Number mul(Number n1, Number n2) {
//        System.out.println("IntNumber = " + n1.intNum * n2.intNum );
        return new IntNumber(n1.intNum * n2.intNum) ;


    }

    @Override
    public Number div(Number n1, Number n2){
        return (n2)  ;

    }
}
