package com.alex.exercise;


public class Client extends Thread {
    private Broker broker;
    private String clientName;
    private int totalShares;

    public Client(Broker _broker, String _clientName) {
        broker = _broker;
        clientName = _clientName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * (2000 - 1000) + 1000));
                int randomShares = (int) (Math.random() * (5 - 1) + 1);
                if (broker.buy(randomShares)) {
                    totalShares += randomShares;
                    System.out.println("Client " + clientName + " bought " + randomShares);
                } else {
                    System.out.println("Client " + clientName + " couldn't buy any shares.");
                }
            } catch (InterruptedException e) {
                System.out.println("Client " + clientName + " Total shares bought: " + totalShares);
                break;
            }
        }
    }

}
