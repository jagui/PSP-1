package com.alex.exercise;

public class Broker {
    private int numberOfShares;
    private int availableShares;

    public Broker(int _numberOfShares) {
        numberOfShares = _numberOfShares;
        availableShares = numberOfShares;
    }

    public synchronized boolean buy(int amountToBuy) {
        if (availableShares >= amountToBuy) {
            System.out.println(availableShares + " available shares");
            availableShares -= amountToBuy;
            notifyAll();
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    public synchronized void waitUntilNoSharesAvailable() throws InterruptedException {
        while (availableShares > 0) {
            wait();
        }
    }
}
