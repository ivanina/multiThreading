package org.ivanina.dev.shdt.ch11_base;

public class DeadlockSrcB implements Deadlock {
    synchronized public void foo(Deadlock a){
        System.out.println(Thread.currentThread().getName()+ " entered in method 'foo' of class 'DeadlockSrcB'");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " try call 'last' of class 'DeadlockSrcA'");
        a.last();
    }
    synchronized public void last(){
        System.out.println(Thread.currentThread().getName()+ " entered in method 'last' of class 'DeadlockSrcB'");
    }
}
