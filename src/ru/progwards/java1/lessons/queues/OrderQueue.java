package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;


class OrderQueue {


    Comparator<Order> comparatorPriority = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return Integer.compare(o1.getPriority(), o2.getPriority());

        }
    };

    Comparator<Order> comparatorNum = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return Integer.compare(o1.getNum(), o2.getNum());
        }
    };

//    PriorityQueue<Order> priorityQueue = new PriorityQueue(comparator);
PriorityQueue<Order> priorityQueue = new PriorityQueue(comparatorPriority.thenComparing(comparatorNum));

    public void add(Order order) {
        priorityQueue.offer(order);
    }

    public Order get() {
        return priorityQueue.poll();
    }


    public static void main(String[] args) {

        OrderQueue test = new OrderQueue();
        test.add(new Order(29718.0));//27626.0, 17511.0, 976.0, 22274.0, 16329.0, 406.0, 26657.0, 418.0, 6697.0, 13632.0, 14567.0, 3664.0, 27914.0, 23228.0, 28458.0, 9540.0, 23270.0, 8199.0, 6181.0, 21914.0, 1955.0, 4459.0, 26483.0, 7092.0
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



