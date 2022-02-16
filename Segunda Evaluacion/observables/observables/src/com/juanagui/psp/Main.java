package com.juanagui.psp;

import java.util.Observable;

public class Main {


    public static void main(String[] args) {
       Observable observable = new MyObservable();

        MyObserver observer1 = new MyObserver("observer1");
        MyObserver observer2 = new MyObserver("observer2");

        observable.addObserver(observer1);
        observable.addObserver(observer2);

        observable.notifyObservers("Hola PSP");
    }
}
