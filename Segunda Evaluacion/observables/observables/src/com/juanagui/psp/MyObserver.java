package com.juanagui.psp;

import java.util.Observable;

public class MyObserver implements java.util.Observer {

    private final String name;

    public MyObserver(String name) {

        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.printf("%s: %s%n", name, arg.toString());
    }
}
