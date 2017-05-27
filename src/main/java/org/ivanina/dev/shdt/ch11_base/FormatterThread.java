package org.ivanina.dev.shdt.ch11_base;

public class FormatterThread implements Runnable {
    private Formatter formatter;
    private String msg;

    public FormatterThread(String msg, Formatter formatter) {
        this.msg = msg;
        this.formatter = formatter;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        formatter.call(msg);
    }
}
