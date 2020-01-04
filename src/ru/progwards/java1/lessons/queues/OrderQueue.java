package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;


class OrderQueue {

    Comparator<Order> comparator = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return Integer.compare(o1.getPriority(), o2.getPriority());
        }
    };

    PriorityQueue<Order> priorityQueue = new PriorityQueue(comparator);

    public void add(Order order) {
        priorityQueue.offer(order);
    }

    public Order get() {
        return priorityQueue.poll();
    }


    public static void main(String[] args) {

        OrderQueue test = new OrderQueue();
        test.add(new Order(7000));
        test.add(new Order(25000));
        test.add(new Order(10000));
        test.add(new Order(15000));
        test.add(new Order(50000));
        test.add(new Order(30000));


        System.out.println(test.get().toString());
        System.out.println(test.get().toString());
        System.out.println(test.get().toString());
        System.out.println(test.get().toString());
        System.out.println(test.get().toString());
        System.out.println(test.get().toString());
        System.out.println(test.get());

    }
}



