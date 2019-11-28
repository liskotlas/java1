package ru.progwards.java1.lessons.Training;


import ru.progwards.java1.lessons.abstractnum.Figure3D;
import ru.progwards.java1.lessons.abstractnum.Number;

public class Cube extends Figure3D {


@Override
    public Number volume() {
       return  segment.mul(segment, (segment.mul(segment, segment)));
    }
}

