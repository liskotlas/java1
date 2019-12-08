package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    int num;
    public Binary(int num){
        this.num = num;
    }
    public String toString(){
        String tmp = "";
        for (int i = 7; i>=0; i--) {
            tmp += String.valueOf((byte)this.num >> i & 0b00000001);
        }
        return tmp;
    }
    public static void main(String[] args) {
        System.out.println(new Binary(10 ).toString());
    }
}
