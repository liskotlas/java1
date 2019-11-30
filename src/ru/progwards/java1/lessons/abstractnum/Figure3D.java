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

// Код для проверки
    public static void main(String[] args) {

        Figure3D cube = new Cube();
        cube.segment = new IntNumber((int)3);
        System.out.println("Сегмент = " + cube.segment);
        System.out.println("Объем куба равен " + cube.volume());

        Figure3D ball = new Ball();
        ball.segment = new DoubleNumber(2.5);
        System.out.println("Сегмент = " + ball.segment);
        System.out.println("Объем шара равен " + ball.volume());
    }

}