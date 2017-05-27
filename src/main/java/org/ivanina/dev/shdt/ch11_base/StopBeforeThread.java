package org.ivanina.dev.shdt.ch11_base;

public class StopBeforeThread implements Runnable {
    int integrations;
    String name;
    Thread t;

    public StopBeforeThread(String name ,int integrations ) {
        this.integrations = integrations;
        this.name = name;
        t = new Thread(this,name);
        System.out.println("Thread "+name+" start");
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < integrations; i++){
                System.out.println("  " + name + " ...");
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(" >> " + name + " done");
    }
}
