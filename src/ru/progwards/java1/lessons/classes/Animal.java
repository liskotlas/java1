package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;

    public Animal(){

    }

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

    public AnimalKind getKind(){
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    public String toString() {
        return "I am " + getKind() + "eat " + getFoodKind() + CalculateFoodWeight();
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
}
