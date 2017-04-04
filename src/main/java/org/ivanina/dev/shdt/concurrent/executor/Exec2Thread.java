package org.ivanina.dev.shdt.concurrent.executor;

public class Exec2Thread implements Runnable {
    String name;

    public Exec2Thread(String name) {
        this.name = name;
        new Thread(this,name);
    }

    @Override
    public void run() {
        try {
            System.out.println("  >> " + name + " started");
            Thread.sleep(3000);
            System.out.println("<< " + name + " finished");
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
