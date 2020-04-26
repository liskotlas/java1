package ru.progwards.java2.lessons.synchro;

enum stateFork{
    BUSY,
    FREE
}


public class Fork {


    volatile stateFork state = stateFork.FREE;



    public synchronized stateFork getFork(){
        return state;
    }

    public synchronized void setFork(stateFork state){
        this.state = state;
    }
}
