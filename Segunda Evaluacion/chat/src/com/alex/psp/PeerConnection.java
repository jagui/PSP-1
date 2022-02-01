package com.alex.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class PeerConnection extends Thread implements Observer {
    private final Socket clientSocket;
    private final Observable observable;
    private final PrintWriter socketOut;

    public PeerConnection(Socket clientSocket, Observable observable) throws IOException {
        this.clientSocket = clientSocket;
        this.observable = observable;
        this.socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        observable.addObserver(this);
    }

    @Override
    public void run() {
        try (
                BufferedReader socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String line;
            while ((line = socketIn.readLine()) != null) {
                observable.notifyObservers(line);
                //socketOut.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socketOut.close();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        socketOut.write(arg.toString());
    }
}
