package org.ivanina.dev.shdt.ch11_base;

public class DeadlockSrcA implements Deadlock {

    synchronized public void foo(Deadlock b){
        System.out.println(Thread.currentThread().getName()+ " entered in method 'foo' of class 'DeadlockSrcA'");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " try call 'last' of class 'DeadlockSrcB'");
        b.last();
    }

    synchronized public void last(){
        System.out.println(Thread.currentThread().getName()+ " entered in method 'last' of class 'DeadlockSrcA'");
    }
}
