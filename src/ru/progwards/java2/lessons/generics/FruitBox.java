package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;


public class FruitBox<T extends Fruit> extends ArrayList{

    float mass = 0;

    public FruitBox(){
        super();
    }

    public void addFruit (Fruit fruit){

        if(this.size() == 0){
            add(fruit);
            this.mass = fruit.getMass();
        }else
        if (this.get(0).getClass() == fruit.getClass()){
            add(fruit);
        }else {
            throw new UnsupportedOperationException();
        }
    }

    public float getWeight(){
        if (this.size() == 0){

            return 0;
        }
        return this.size()* this.mass;
    }

    public void moveTo(FruitBox box){
        if (this.get(0).getClass() == box.get(0).getClass()) {
            box.addAll(this);
            this.clear();
            this.mass = 0;
        }else {
            throw new UnsupportedOperationException();
        }
    }




    public static void main(String[] args) {

        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Orange> orangeBox = new FruitBox<>();
        Apple apple1 = new Apple();
        Orange orange1 = new Orange();

        appleBox.addFruit(orange1);
        appleBox.addFruit(orange1);
        System.out.println(appleBox.getWeight());


//        appleBox.
//        System.out.println(apple1.getClass());
//        System.out.println();

    }

    public int compareTo(FruitBox o) {
        if(this.getWeight() < o.getWeight()){
            return -1;
        }
        if (this.getWeight() == o.getWeight()){
            return 0;
        }
        return 1;
    }



}


