package ru.progwards.java1.lessons.bigints;


import java.math.BigInteger;

abstract class AbsInteger {
    AbsInteger number;

    AbsInteger () {
    }
@Override
    public String toString(){
        return null;
    }

    public AbsInteger newNumber(String strNum){
        return null;
    }



    public
        static AbsInteger add(AbsInteger num1, AbsInteger num2){
            Integer res = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
            if (res >= Byte.MIN_VALUE && res <= Byte.MAX_VALUE){
                return  new ByteInteger((byte) (Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString())));
            }
            if (res >= Short.MIN_VALUE && res <= Short.MAX_VALUE){
                return  new ShortInteger((short) (Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString())));
            }
            return new IntInteger((int) (Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString())));
    }

        public static void main(String[] args) {
            AbsInteger num1 = new ByteInteger((byte) 500000000);
            AbsInteger num2 = new ShortInteger((short) 500000000);
            System.out.println(add(num1, num2).getClass());
        }
}
