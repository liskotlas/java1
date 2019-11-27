package ru.progwards.java1.lessons.abstractnum;

public class Cube extends Figure3D{

    @Override

    public Number volume(){
        Number vol = segment.mul(segment, (Number) segment.mul(segment, segment));
        return vol;
    }
}
