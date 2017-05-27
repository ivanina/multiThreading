package org.ivanina.dev.shdt.ch11_base;

public class FormatterMain {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        FormatterThread a = new FormatterThread("Text for A thread",formatter);
        FormatterThread b = new FormatterThread("Text for B thread",formatter);
    }
}
