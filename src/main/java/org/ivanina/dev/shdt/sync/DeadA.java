package org.ivanina.dev.shdt.sync;

public class DeadA {
    synchronized void foo(DeadB b){
        System.out.println(Thread.currentThread().getName()+" entered to method 'DeadA.foo(DeadB b)'");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(Thread.currentThread().getName()+" try call method 'DeadB.last()'");
        b.last();
    }
    synchronized void last(){
        System.out.println(Thread.currentThread().getName()+" entered to method 'DeadA.last()'");
    }
}
