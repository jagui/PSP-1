package com.juanagui.psp;

public class Counter {
    public static final int MAX_COUNT = 1000;

    private int c = 0;

    public void increment() {
        synchronized (this){
            c++;
        }
    }

    public  void decrement() {
        synchronized (this){
            c--;
        }
    }

    public int value() {
        synchronized (this){
            return c;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread incrementer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAX_COUNT; i++) {
                    counter.increment();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread decrementer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAX_COUNT; i++) {
                    counter.decrement();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        incrementer.start();
        decrementer.start();
        incrementer.join();
        decrementer.join();
        System.out.println(counter.value());
    }
}
