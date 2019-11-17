package ru.progwards.java1.lessons.abstractnum;

public class Cube extends Figure3D{

    @Override
    public Number volume(){
        return segment * segment * segment;
    }
}
