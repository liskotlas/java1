package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a, b;


    public ComplexNum(int a, int b){
        this.a = a;
        this.b = b;
    }

    public String toString(){
        String string = a + "+" + b + "i";
        return string;
    }

    public ComplexNum add(ComplexNum num1, ComplexNum num2){
        return new ComplexNum(num1.a + num2.a, num1.b + num2.b);
    }

    public ComplexNum sub(ComplexNum num1, ComplexNum num2){
        return new ComplexNum(num1.a - num2.a, num1.b - num2.b);
    }

    public ComplexNum mul(ComplexNum num1, ComplexNum num2){
        return new ComplexNum(num1.a * num2.b - num1.b * num2.b, num1.b * num2.a + num1.a * num2.b);
    }

    public ComplexNum div(ComplexNum num1, ComplexNum num2){
        return new ComplexNum((num1.a * num2.a + num1.b * num2.b) / (num2.a * num2.a + num2.b * num2.b), (num1.b * num2.a - num1.a * num2.b) / (num2.a * num2.a + num2.b * num2.b));
    }
}
