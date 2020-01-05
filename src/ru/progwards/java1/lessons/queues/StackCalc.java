package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class StackCalc {

    ArrayDeque deque = new ArrayDeque();

    public void push(double value) {
        deque.push(value);
    }

    public double pop() {
        return (double) deque.pop();
    }

    public void add() {
        deque.push((double) deque.pop() + (double) deque.pop());
    }

    public void sub() {

//        deque.push(- (double) deque.pop() + (double) deque.pop());

        deque.push( (double) deque.pop() - (double) deque.pop());
    }

    public void mul() {
        deque.push((double) deque.pop() * (double) deque.pop());
    }

    public void div() {

        deque.push((double) deque.pop() * (1 / (double) deque.pop()));

//        deque.push(1 / (double) deque.pop() * (double) deque.pop());
    }
}

class Calculate {

    public static double calculation1() { //2.2*(3+12.1)

        StackCalc stackCalc = new StackCalc();
        stackCalc.push(2.2);
        stackCalc.push(3);
        stackCalc.push(12.1);
        stackCalc.add();
        stackCalc.mul();
        return stackCalc.pop();
    }

    public static double calculation2() { //(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2))

        StackCalc stackCalc = new StackCalc();
        stackCalc.push(87);
        stackCalc.push(2);
        stackCalc.push(13.001);
        stackCalc.push(9.2);
        stackCalc.sub();
        stackCalc.mul();
        stackCalc.add();
        stackCalc.push(19);
        stackCalc.push(3.33);
        stackCalc.sub();
        stackCalc.mul(); // конец второг слагаемого
        stackCalc.push(737.22);
        stackCalc.push(24);
        stackCalc.add();
        stackCalc.push(55.6);
        stackCalc.push(12.1);
        stackCalc.sub();
        stackCalc.div();
        stackCalc.add();
        return stackCalc.pop();
    }

    public static void main(String[] args) {
        StackCalc stackCalc = new StackCalc();
        stackCalc.push(8.0);
        stackCalc.push(6.0);
        stackCalc.push(5.0);

        stackCalc.div();
        System.out.println(stackCalc.pop());
        System.out.println(stackCalc.pop());
    }
}

