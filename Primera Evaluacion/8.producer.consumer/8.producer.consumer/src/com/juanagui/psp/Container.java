package com.juanagui.psp;

class Container {
    private int _value;
    private boolean _valueAvailable;

    public synchronized void put(int i) {
        while (_valueAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        _value = i;
        _valueAvailable = true;
        notifyAll();
    }

    public synchronized int get() {
        while (!_valueAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        _valueAvailable = false;
        notifyAll();
        return _value;
    }
}
