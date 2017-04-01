package org.ivanina.dev.shdt.base;

public class Thread1Demo {
    public static void main(String ars[]){
        for (int i = 0; i < 3; i++) {
            new Thread1RunnableDmo("= A:"+i+"= . ThreadRunnableDmo");
        }
        new Thread1ThreadDmo("= B = . Thread1ThreadDmo");

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " MAIN thread.");
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(" >>> Main thread is finished. "+ Thread.currentThread());
    }
}
