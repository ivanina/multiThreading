package org.ivanina.dev.shdt.sync;

public class StoreQuery {
    int n;
    boolean isValueSet = false;
    synchronized int get(){
        while (!isValueSet){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Received: "+n);
        isValueSet = false;
        notify();
        return n;
    }
    synchronized void put(int n){
        while (isValueSet){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        this.n = n;
        System.out.println("Sent: "+this.n);
        isValueSet = true;
        notify();
    }
}
