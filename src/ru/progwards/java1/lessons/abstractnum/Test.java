package ru.progwards.java1.lessons.abstractnum;

public class Test {
    public static void main(String[] args) {
        Figure3D intCube = new Cube(new IntNumber(3));
        System.out.println(intCube.volume());


        Figure3D dblCube = new Cube(new DoubleNumber((double)3));
        System.out.println(dblCube.volume());

        Figure3D intPyramid = new Pyramid(new IntNumber(3));
        System.out.println(intPyramid.volume());


        Figure3D dblPyramyd = new Pyramid(new DoubleNumber((double) 3));
        System.out.println(dblPyramyd.volume());
    }
}


