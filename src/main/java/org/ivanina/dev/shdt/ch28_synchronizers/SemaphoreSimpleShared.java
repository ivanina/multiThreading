package org.ivanina.dev.shdt.ch28_synchronizers;

public class SemaphoreSimpleShared {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increment(){
        counter++;
    }

    public void decrement(){
        counter--;
    }
}
