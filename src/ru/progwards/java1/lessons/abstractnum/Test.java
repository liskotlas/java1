package ru.progwards.java1.lessons.abstractnum;

public class Test {
    public static void main(String[] args) {
        Figure3D cube = new Cube(new IntNumber(3));
        System.out.println(cube.volume());

//
//        fig = new Cube(new DoubleNumber(3.0));
//        System.out.println(fig.volume());
//
//        fig = new Pyramid(new IntNumber(3));
//        System.out.println(fig.volume());
//
//        fig = new Pyramid(new DoubleNumber(3.0));
//        System.out.println(fig.volume());
    }


//    public static void main(String[] args) {
//
//        Figure3D cube = new Cube(new IntNumber(3));
//        System.out.println("Объем куба равен " + cube.volume());
//
//        Figure3D intPyramid = new Pyramid(new IntNumber(3));
//        System.out.println("Объем пирамиды равен " + intPyramid.volume());
//
//
//        Figure3D dblPyramyd = new Pyramid(new DoubleNumber(3.0));
//        System.out.println("Объем пирамиды равен " + dblPyramyd.volume());
//    }
}


