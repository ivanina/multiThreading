package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.Exchanger;

public class ExchangerBuffer implements Runnable {
    private Exchanger<String> exchanger;
    private int integrations;
    private String str="";

    public ExchangerBuffer(Exchanger<String> exchanger, int integrations) {
        this.exchanger = exchanger;
        this.integrations = integrations;
        new Thread(this).start();
    }

    @Override
    public void run() {
        char ch = 'A';
        try {
            for (int i = 0; i < integrations; i++){
                for(int j = 0; j < 5; j++){
                    str += ch++;
                }
                str = exchanger.exchange(str);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
