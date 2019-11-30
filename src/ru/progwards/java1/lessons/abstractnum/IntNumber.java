package ru.progwards.java1.lessons.abstractnum;

public class IntNumber extends Number {
    int intNumber;

    public IntNumber (int intNum){
        this.intNumber = intNum;
    }

    @Override
    public Number newNumber(String strNum){
        return new IntNumber(Integer.parseInt(strNum));

    }
    @Override
    public Number mul(Number n1, Number n2) {
//       System.out.println(Integer.parseInt(n1.toString()) * Integer.parseInt(n2.toString()));
       Integer n = Integer.parseInt(n1.toString()) * Integer.parseInt(n2.toString());
       return newNumber(n.toString());


    }

    @Override
    public Number div(Number n1, Number n2) {
        Integer n = Integer.parseInt(n1.toString()) / Integer.parseInt(n2.toString());
        return newNumber(n.toString());
    }


    @Override
        public String toString() {
            return ((Integer)intNumber).toString();
    }
}
