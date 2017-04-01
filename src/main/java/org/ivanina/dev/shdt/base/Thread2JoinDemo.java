package org.ivanina.dev.shdt.base;

public class Thread2JoinDemo implements Runnable {
    Thread thread;
    Thread2JoinDemo(String name, int priority){
        thread = new Thread(this,name);
        thread.setPriority(priority);
        System.out.println(">> New thread: "+thread);
        thread.start();
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.getName()+ ": "+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(">>> Thread is Finished. "+thread);
    }
}
