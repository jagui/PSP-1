package com.juanagui.psp;

public class JoinTimeout {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int sum = 0;
                    for (int i = 0; i < Integer.MAX_VALUE; i++)
                        sum += i;
                    System.out.println(sum);
                    if (Thread.interrupted()) {
                        System.out.println("Interrupted");
                        break;
                    }
                }
            }
        });
        thread.start();
        int remainingWaits = 3;
        while (thread.isAlive()) {
            thread.join(2000);
            System.out.println("Still waiting for thread");
            if (--remainingWaits < 0) {
                thread.interrupt();
                thread.join();
            }
        }
    }
}
