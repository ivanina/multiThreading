package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.Exchanger;

public class ExchangerFormatter implements Runnable {
    private Exchanger<String> exchanger;
    private int integrations;

    public ExchangerFormatter(Exchanger<String> exchanger, int integrations) {
        this.exchanger = exchanger;
        this.integrations = integrations;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            for(int i = 0 ; i < integrations; i++){
                System.out.println("Received: ["+exchanger.exchange(new String())+"]");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
