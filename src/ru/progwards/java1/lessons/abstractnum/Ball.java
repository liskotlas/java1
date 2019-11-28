package ru.progwards.java1.lessons.abstractnum;

public class Ball extends Figure3D {
//    private java.lang.Number res;

@Override
        public Number volume() {
            Number pi = segment.newNumber("3.1415926535");
    System.out.println("Pi = " + pi.dblNum);
            Number three = segment.newNumber("3");
            Number four = segment.newNumber("4");
            Number vol_1 = segment.mul (segment, segment.mul(segment, segment));
            Number vol_2 = segment.div(segment.mul(pi, four), three);
            Number vol = segment.mul(vol_1, vol_2);
            return  vol;
    }
}
