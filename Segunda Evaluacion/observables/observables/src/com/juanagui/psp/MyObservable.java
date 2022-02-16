package com.juanagui.psp;

import java.util.Observable;

public class MyObservable extends Observable {

    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }
}
