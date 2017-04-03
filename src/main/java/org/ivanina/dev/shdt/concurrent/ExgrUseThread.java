package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Exchanger;

public class ExgrUseThread implements Runnable {
    Exchanger<String> exgr;

    public ExgrUseThread(Exchanger<String> exgr) {
        this.exgr = exgr;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("<< received: " + exgr.exchange("ok"));
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
