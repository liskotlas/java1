package ru.progwards.java1.lessons.Training;

class Person {
    public String name;
    public Person(String name) {
        this.name = name;
    }
}

abstract class PersonCompare {
    public int compare(Person p1, Person p2) {
        return 0;
    }


    PersonCompare personCompare = new PersonCompare() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.name.compareTo(p2.name);
        }
    };

}


