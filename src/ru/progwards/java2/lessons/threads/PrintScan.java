package ru.progwards.java2.lessons.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintScan{



    static void print(String name, int pages){
        new Thread(new Print(name, pages)).start();
    }

    static void scan(String name, int pages){
        new Thread(new Scan(name, pages)).start();
    }


    public static void main(String[] args) {
        print("One", 1);
        print("Two", 2);
        scan("One", 1);
        scan("Two", 2);
        print("Three", 3);

    }
}

class Print implements Runnable{

    String name = "";
    int pages = 0;

    public Print(String name, int pages){
        this.name = name;
        this.pages = pages;
    }

    static Lock lock = new ReentrantLock();
    public static void printOut(String name, int pages){

        lock.lock();
        try {
            for (int i = 1; i <= pages; i++) {
                System.out.println("print " + name + " page " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        printOut(this.name, this.pages);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Scan implements Runnable{

    String name = "";
    int pages = 0;

    public Scan(String name, int pages){
        this.name = name;
        this.pages = pages;
    }

//    Lock lock = new ReentrantLock();
    public synchronized void scanOut(String name, int pages){
//        lock.lock();
//        try {
            for (int i = 1; i <= pages; i++) {
                System.out.println("scan " + name + " page " + i);
            }

//        }finally {
//            lock.unlock();
//        }
    }

    @Override
    public void run() {
        scanOut(this.name, this.pages);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}