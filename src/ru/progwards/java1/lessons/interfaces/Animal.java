//package ru.progwards.java1.lessons.interfaces;
//
//import java.util.Objects;
//
//public class Animal implements Comparable<Animal> {
//    double weight;
//
//    @Override
//    public int compareTo(Animal animal) {
//        if (Animal.this.weight == animal.weight){
//            return 0;
//        }
//        if (Animal.this.weight < animal.weight) {
//            return -1;
//        }
//        return 1;
//    }
//
//
//    enum AnimalKind {
//        ANIMAL,
//        COW,
//        HAMSTER,
//        DUCK
//    }
//
//    enum FoodKind {
//        UNKNOWN,
//        HAY,
//        CORN
//    }
//
//    public double getFood1kgPrice(){
//        switch (getFoodKind()){
//            case UNKNOWN:
//                return 0;
//            case HAY:
//                return 20;
//            case CORN:
//                return 50;
//        }
//        return 0;
//    }
//
//    public double getFoodPrice(){
//        return calculateFoodWeight() * getFood1kgPrice();
//    }
//
//    public int compareFoodPrice(Animal animal){
//       return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
//    }
//
//    public AnimalKind getKind(){
//            return AnimalKind.ANIMAL;
//    }
//
//    public FoodKind getFoodKind() {
//        return FoodKind.UNKNOWN;
//    }
//
//    public String toString() {
//        return "I am " + getKind() + ", eat " + getFoodKind() + calculateFoodWeight();
//    }
//
//    public double getWeight(){
//        return 1;
//    }
//
//    public Animal(double Weight){
//        this.weight = Weight;
//    }
//
//    public double getFoodCoeff(){
//        return 0.02;
//    }
//
//    public double calculateFoodWeight(){
//        return weight * getFoodCoeff();
//    }
//
//    @Override
//    public boolean equals(Object anObject) {
//        if (this == anObject) return true;
//        if (anObject == null || getClass() != anObject.getClass()) return false;
//        Animal animal = (Animal) anObject;
//        return Double.compare(animal.weight, weight) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(weight);
//    }
//}
//
//
