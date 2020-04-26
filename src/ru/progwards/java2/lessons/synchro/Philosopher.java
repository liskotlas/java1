package ru.progwards.java2.lessons.synchro;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Callable {

    String name;
    Fork right;
    Fork left;
    long resultReflectTime;
    long resultEatTime;
    long reflectTime;
    long eatTime;
    int countReflect = 0;
    int countEat = 0;
    ReentrantLock lock;

    public Philosopher(String name, Fork left, Fork right, long reflectTime, long eatTime, ReentrantLock lock) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.reflectTime = reflectTime;
        this.eatTime = eatTime;
        this.lock = lock;
    }

    void reflect() {

        System.out.println(name + " размышляет");
        try {
            Thread.sleep(this.reflectTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countReflect++;
        resultReflectTime = countReflect * reflectTime;

    }

    void eat() {

        System.out.println(name + " ест");
        try {
            Thread.sleep(this.eatTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countEat++;
        resultEatTime = countEat * eatTime;
    }


    void setForkFree(){
        lock.lock();
        try {
            left.setFork(stateFork.FREE);
            right.setFork(stateFork.FREE);
        }
        finally {
            lock.unlock();
        }
    }


    public boolean runEat(){
        lock.lock();
        try {
            if (left.getFork() == stateFork.FREE) {
                left.setFork(stateFork.BUSY);
                if (right.getFork() == stateFork.FREE) {
                    right.setFork(stateFork.BUSY);
                    return true;
                } else {
                    left.setFork(stateFork.FREE);
                    return false;
                }
            }
            return false;
        }
        finally {
            lock.unlock();
        }
    }


    @Override
    public String call() throws Exception {

        while (!Simposion.stop.get()) {
//            System.out.println(Simposion.stop.get());
            if (runEat()) {
                eat();
                reflect();
                setForkFree();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Философ " + this.name + ". Ел - " + resultEatTime + ", размышлял - " + resultReflectTime);
        return this.name;
    }

}
