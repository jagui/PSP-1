package com.alex.psp;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Server {
    public static final int MAX_PORT_NUMBER = 65535;
    public static final int MIN_PORT_NUMBER = 1;

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }
        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("<port number> must be an integer value");
            System.exit(1);
        }
        if (portNumber < MIN_PORT_NUMBER || portNumber > MAX_PORT_NUMBER) {
            System.err.printf("<port number> must be an integer value between %d and %d%n", MIN_PORT_NUMBER, MAX_PORT_NUMBER);
            System.exit(1);
        }


        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
        ) {
            Observable observable = new Observable();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PeerConnection peerConnection = new PeerConnection(clientSocket, observable);
                peerConnection.start();
            }

        } catch (
                BindException e) {
            System.err.printf("port %d is already in use%n", portNumber);
            System.exit(1);
        }

    }
}
