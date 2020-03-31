package ru.progwards.java2.lessons.reflection;

class Person {
    private String name;
    public Person() {
    }
        private Person(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
//    public void setName(String name) {
//        this.name = name;
//    }
}
