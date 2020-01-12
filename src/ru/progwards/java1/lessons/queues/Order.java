package ru.progwards.java1.lessons.queues;

import java.util.Comparator;

public class Order  {

    private double sum;
    private int priority;

    public Order(double sum) {
        this.sum = sum;
        if (sum <= 10_000) {
            priority = 3;
        }
        if (sum > 10_000 && sum <= 20_000) {
            priority = 2;
        }
        if (sum > 20_000){
            priority = 1;
        }
    }

    public double getSum() {
        return sum;
    }

    public int getPriority() {
        return priority;
    }

    public  int getNum(){
        return 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "sum=" + sum +
                ", priority=" + priority +
                '}';
    }
}
