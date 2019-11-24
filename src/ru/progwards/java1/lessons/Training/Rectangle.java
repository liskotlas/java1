package ru.progwards.java1.lessons.Training;

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
        Double r1 = new Rectangle(1, 1).area();
        Double r2 = new Rectangle(2, 2).area();
        System.out.println(r1.compareTo(r2));
    }
}