package ru.progwards.java1.lessons.classes;

import java.util.Objects;

public class Animal  {
    double weight;


    enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    enum FoodKind {
        UNKNOWN,
        HAY,
        CORN
    }

    public double getFood1kgPrice(){
        switch (getFoodKind()){
            case UNKNOWN:
                return 0;
            case HAY:
                return 20;
            case CORN:
                return 50;
        }
        return 0;
    }

    public double getFoodPrice(){
        return CalculateFoodWeight() * getFood1kgPrice();
    }

    public int compareFoodPrice(Animal animal){
       return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }

    public AnimalKind getKind(){
            return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    public String toString() {
        return "I am " + getKind() + ", eat " + getFoodKind() + CalculateFoodWeight();
    }

    public double getWeight(){
        return 1;
    }

    public Animal (double Weight){
        this.weight = Weight;
    }

    public double getFoodCoeff(){
        return 0.02;
    }

    public double CalculateFoodWeight(){
        return weight * getFoodCoeff();
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
        return Double.compare(animal.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    public static void main(String[] args) {
        Animal animal = new Animal(10);
        System.out.println(animal.toString());
        Duck duck = new Duck(10);
        System.out.println(duck.toString());
        System.out.println(new Cow(10).toString());
        System.out.println(new Hamster(10).toString());
    }


}

