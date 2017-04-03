package org.ivanina.dev.shdt.concurrent;

import java.util.concurrent.Exchanger;

public class ExgrDemo {
    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();
        new ExgrUseThread(exgr);
        new ExgrMakeThread(exgr);

    }
}
