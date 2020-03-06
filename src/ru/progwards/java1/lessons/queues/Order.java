package ru.progwards.java1.lessons.queues;



public class Order  {

    private double sum;
    private int priority;
    private static int num;
    private int numOrder;



    public Order(double sum) {

        this.num++;
        this.numOrder = this.num;
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
        return this.numOrder;
    }

    @Override
    public String toString() {
        return "Order{ num = " + numOrder +
                ", sum = " + sum +
                ", priority = " + priority +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Order(10000).toString());
        System.out.println(new Order(10000).toString());
        System.out.println(new Order(10000).toString());
    }
}


