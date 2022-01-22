package com.juanagui.psp;

public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    System.out.println("Running");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                        break;
                    }
                }
            }
        });
        thread.start();
        thread.join();
    }
}
