package ru.progwards.java1.lessons.Training;

import java.util.Objects;

class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public int compareTo(Rectangle anRectangle) {
        Double x = this.area();
        Double y = anRectangle.area();
        return x.compareTo(y);
    }

    public double area() {
        return a*b;
    }

    public static void main(String[] args) {
        Double r1 = new Rectangle(3, 4).area();
        Double r2 = new Rectangle(6, 2).area();
        System.out.println(r1.equals(r2));
        System.out.println();
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Rectangle rectangle = (Rectangle) anObject;
        return Double.compare(rectangle.a, a) == 0 &&
                Double.compare(rectangle.b*rectangle.a, a*b) == 0 || Double.compare(rectangle.a, b) == 0 &&
                Double.compare(rectangle.b, a) ==  0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}