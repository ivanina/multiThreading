package org.ivanina.dev.shdt.ch11_base;

public interface Deadlock {
    void foo(Deadlock x);
    void last();
}
