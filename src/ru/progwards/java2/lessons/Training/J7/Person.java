package ru.progwards.java2.lessons.Training.J7;

public class Person {

    private String name;

    public Person(){
        this.name = "Misha";
    }

    private Person(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    private void setName(String name) {
        this.name = name;
        System.out.println(this.name);
    }
}
