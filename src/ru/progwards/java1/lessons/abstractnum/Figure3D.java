package ru.progwards.java1.lessons.abstractnum;

public class Figure3D {
    public Number segment;

    public Figure3D() {

    }

    public Figure3D(Number segment) {
        this.segment = segment;
    }

    public Number volume() {
        return null;
    }


    public static void main(String[] args) {
        Figure3D cube = new Cube();
        cube.segment = new IntNumber(3);
        System.out.println("Сегмент = " + cube.segment.intNum);
        System.out.println("Объем куба равен " + cube.volume().intNum);



    }
}