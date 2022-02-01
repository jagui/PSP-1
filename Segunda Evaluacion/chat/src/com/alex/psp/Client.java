package com.alex.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Usage: java Server <ip address> <port number>");
            System.exit(1);
        }
        InetAddress address = null;
        try {
            address = InetAddress.getByName(args[0]);
        } catch (UnknownHostException e) {
            System.err.printf("Usage <ip address> %s invalid", args[0]);
            System.exit(1);
        }
        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("<port number> must be an integer value");
            System.exit(1);
        }
        if (!address.isReachable(1)) {
            System.err.printf("Usage: can't reach <ip address> %s\n", args[0]);
            System.exit(1);
        }


        if (portNumber < Server.MIN_PORT_NUMBER || portNumber > Server.MAX_PORT_NUMBER) {
            System.err.printf("<port number> must be an integer value between %d and %d%n", Server.MIN_PORT_NUMBER, Server.MAX_PORT_NUMBER);
            System.exit(1);
        }

        try (
                Socket socket = new Socket(address, portNumber);
                BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader stdInt = new BufferedReader(new InputStreamReader(System.in));


        ) {
            String line;
            while ((line = stdInt.readLine()) != null) {
                socketOut.println(line);
                System.out.println(socketIn.readLine());
            }
        }
    }
}
