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
        test.add(new Order(29718.0));//29718.0, 26230.0, 8650.0, 2919.0, 12689.0, 21716.0, 5690.0, 18808.0, 8373.0, 12205.0, 3153.0, 24861.0, 26591.0.
        test.add(new Order(26230.0));
        test.add(new Order(8650.0));
        test.add(new Order(2919.0));
        test.add(new Order(12689.0));
        test.add(new Order(21716.0));
        test.add(new Order(5690.0));
        test.add(new Order(18808.0));
        test.add(new Order(8373.0));
        test.add(new Order(12205.0));
        test.add(new Order(3153.0));
        test.add(new Order(24861.0));
        test.add(new Order(26591.0)); // 29718.0, 26230.0, 21716.0, 24861.0, 26591.0, 12689.0, 18808.0, 12205.0, 8650.0, 2919.0, 5690.0, 8373.0, 3153.0




        for (int f = 1; f < 14 ; f++) {
            System.out.println(test.get().toString());
        }

    }
}



