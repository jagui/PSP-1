package com.juanagui.psp;

public class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Hello %d%n", i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HelloThread helloThread1 = new HelloThread();
        helloThread1.start();
        HelloThread helloThread2 = new HelloThread();
        helloThread2.start();
    }
}
