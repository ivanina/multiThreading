package org.ivanina.dev.shdt.ch11_base;

public interface ThreadExtIml {
    void start();
    boolean isAlive();
    Thread.State getState();
    void join() throws InterruptedException;
}
