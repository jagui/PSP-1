package com.alex.exercise;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Broker broker = new Broker(30);
        Client firstClient = new Client(broker, "Alex");
        Client secondClient = new Client(broker, "Sergio");
        Client thirdClient = new Client(broker, "Laura");
        Client fourthClient = new Client(broker, "Manuel");
        List<Client> clients = new ArrayList<>();
        clients.add(firstClient);
        clients.add(secondClient);
        clients.add(thirdClient);
        clients.add(fourthClient);
        // Run clients threads
        for (Client c : clients) {
            c.start();
        }
        // wait until share
        broker.waitUntilNoSharesAvailable();
        // Interrupt client threads
        for (Client c : clients) {
            c.interrupt();
        }
        for(Client c:clients){
            c.join();
        }
        System.out.println("Ended program.");
    }
}
