package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;
    public Binary(byte num){
        this.num = (byte) num;
    }
    public String toString(){
        String tmp = "";
        for (int i = 0; i<=7; i++) {
            tmp += String.valueOf(this.num >> i & 0b00000001);
        }
        return tmp;
    }
    public static void main(String[] args) {
        System.out.println(new Binary((byte) 0b01110111).toString());
    }
}
