package org.ivanina.dev.shdt.base;

public class CurrentThreadDemo {
    public static void main(String arg[]){
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread: "+currentThread.getName());
        currentThread.setName("CurrentThreadDemo");
        System.out.println("Current thread renamed: "+currentThread);
        try {
            for(int i=0; i<5; i++){
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }
}
