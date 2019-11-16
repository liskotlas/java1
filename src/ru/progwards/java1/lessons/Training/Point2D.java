package ru.progwards.java1.lessons.Training;

public class Point2D {
    private int x, y;

    public Point2D (int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point2D() {
    }

    @Override
    public String toString(){
        return (x + ", " + y);
    }
}

