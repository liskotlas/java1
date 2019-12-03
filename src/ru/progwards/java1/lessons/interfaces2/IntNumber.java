package ru.progwards.java1.lessons.interfaces2;

public class IntNumber extends Number {


    public int compareTo(Number num) {
        return Integer.compare(Integer.parseInt(this.toString()), Integer.parseInt(num.toString()));
    }


    int number;

    public IntNumber (int num){
        number = num;
    }

    @Override
    public Number newNumber(String strNum){
        return new IntNumber(Integer.parseInt(strNum));

    }
    @Override
    public Number mul(Number num) {
//       System.out.println(Integer.parseInt(n1.toString()) * Integer.parseInt(n2.toString()));
       Integer n_1 = number * Integer.parseInt(num.toString());
       return newNumber(n_1.toString());


    }

    @Override
    public Number div(Number num) {
        Integer n = number / Integer.parseInt(num.toString());
        return newNumber(n.toString());
    }


    @Override
        public String toString() {
            return ((Integer) number).toString();
    }
}
