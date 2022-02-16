package com.alex.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class PeerConnection extends Thread implements Observer {
    private static final String COMMAND_START_CHAR = "/";
    private final Socket clientSocket;
    private final Channel channel;
    private final PrintWriter socketOut;
    private final BufferedReader socketIn;
    private String nickname = "anonymous";

    public PeerConnection(Socket clientSocket, Channel channel) throws IOException {
        this.clientSocket = clientSocket;
        this.channel = channel;
        channel.addObserver(this);
        channel.addObserverToArray(this);
        this.socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }

    @Override
    public void run() {
        try {
            {
                String line;
                String receiverNick;
                String userMessage = null;
                while ((line = socketIn.readLine()) != null) {
                    if ((line.startsWith(COMMAND_START_CHAR))) {
                        String command = line.substring(1);
                        if (command.startsWith("nick")) {
                            String nickname = command.substring(1 + "nick".length());
                            if (nickname.length() > 0) {
                                this.nickname = nickname;
                            }
                        } else if (command.startsWith("priv")) {
                            String subcommand = (command.substring(0));
                            String subcommand2 = (subcommand.substring("priv".length())).substring(1);
                            receiverNick = subcommand2.substring(0, subcommand.indexOf(COMMAND_START_CHAR));
                            userMessage = command.substring("priv".length() + command.indexOf(COMMAND_START_CHAR) + 2);
                            channel.sendMessage(receiverNick, String.format("[%s]-> %s", getNickname(), userMessage));
                        }
                    } else {
                        //channel.sendMessage(getNickname(), String.format("[%s]: %s", getNickname(), line));
                        channel.notifyUpdateAll(channel, String.format("[%s]: %s", getNickname(), line));
                    }
                }
            }
        } catch (IOException e) {
            System.out.printf("%s disconnected %n", clientSocket);
        } finally {
            channel.deleteObserver(this);
            try {
                socketIn.close();
                socketOut.close();
                clientSocket.close();
            } catch (IOException e) {
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        socketOut.println(arg.toString());
    }

    public String getNickname() {
        return nickname;
    }
}
