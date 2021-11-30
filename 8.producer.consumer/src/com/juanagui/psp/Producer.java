package com.juanagui.psp;

public class Producer extends Thread {
    private final Container _container;

    Producer(Container container) {
        _container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            _container.put(i);
            System.out.printf("Producer: container.put(%d)%n", i);
            try {
                Thread.sleep((int) Math.random() * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
