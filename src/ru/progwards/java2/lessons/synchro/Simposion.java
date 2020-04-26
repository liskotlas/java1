package ru.progwards.java2.lessons.synchro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Simposion {

    public static AtomicBoolean stop = new AtomicBoolean(false);


    List<Philosopher> philosopherThreadList = new ArrayList<>();
    List<Fork> forkList = new ArrayList<>();
    ReentrantLock lock = new ReentrantLock();
    ExecutorService service;
    Future<String> future;

    public Simposion(long reflectTime, long eatTime, int number){


        service = Executors.newFixedThreadPool(number);



        for (int i = 0; i < number; i++){
            forkList.add(i, new Fork());
        }


        for (int i = 0; i < number; i++){

            if (i == number - 1){
                philosopherThreadList.add(i, new Philosopher("Philosopher" + (i+1), forkList.get(i), forkList.get(0), reflectTime, eatTime, lock));
                continue;


            }
                philosopherThreadList.add(i, (new Philosopher("Philosopher" + (i+1), forkList.get(i), forkList.get(i+1), reflectTime, eatTime, lock)));
        }


    }

    public void start (){
        for (Philosopher philosoph : philosopherThreadList){
            future = service.submit(philosoph);
        }
    }

    public void stop(){

        stop.set(true);


        service.shutdown();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Simposion simposion = new Simposion(1000, 1000, 5);
        simposion.start();
        Thread.sleep(10000);
        simposion.stop();
    }
}
