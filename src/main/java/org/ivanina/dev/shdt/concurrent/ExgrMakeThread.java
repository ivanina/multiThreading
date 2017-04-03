package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Exchanger;

public class ExgrMakeThread implements Runnable {
    Exchanger<String> exgr;

    public ExgrMakeThread(Exchanger<String> exgr) {
        this.exgr = exgr;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            char ch = 'A';
            for (int n = 0; n < 3; n++) {
                StringBuffer strb = new StringBuffer();
                for (int i = 0; i < 5; i++) {
                    strb.append( ch++ );
                    Thread.sleep(100);
                }
                String str = strb.toString();
                System.out.println("  >> sent: " + str);
                System.out.println("  >> report: " + exgr.exchange(str));
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
