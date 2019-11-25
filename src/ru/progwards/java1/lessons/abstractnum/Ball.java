package ru.progwards.java1.lessons.abstractnum;

public class Ball extends Figure3D {
//    private java.lang.Number res;

    public Ball(Number segment) {
        super(segment);

    }



@Override
        public java.lang.Number volume() {
            Number pi = segment.newNumber("3.1415926535");
            Number three = segment.newNumber("3");
            Number four = segment.newNumber("4");
            java.lang.Number vol = segment.div((Number) segment.mul(segment, four), three);
            return vol;
    }
}
