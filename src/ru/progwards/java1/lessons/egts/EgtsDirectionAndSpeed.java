package ru.progwards.java1.lessons.egts;

public class EgtsDirectionAndSpeed {

    public static int getSpeed(short speedAndDir){
        int result = 0;
        for (int i = 0; i <= 14; i++) {
            result += speedAndDir >> i & 0b00000001;
            System.out.println(Integer.toBinaryString(result));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString( 10));
        System.out.println(getSpeed((short)10));
    }
    }

