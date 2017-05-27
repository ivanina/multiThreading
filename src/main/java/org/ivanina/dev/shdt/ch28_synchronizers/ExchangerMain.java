package org.ivanina.dev.shdt.ch28_synchronizers;

import java.util.concurrent.Exchanger;

public class ExchangerMain {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        int integrations = 4;
        new ExchangerBuffer(exchanger,integrations);
        new ExchangerFormatter(exchanger,integrations);

    }
}
