package com.alex.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class PeerConnection extends Thread implements Observer {
    private static final String COMMAND_START_CHAR = "/";
    private static final String NICK_COMMAND = "nick";
    private static final String PRIV_COMMAND = "priv";
    private final Socket clientSocket;
    private final Channel channel;
    private final PrintWriter socketOut;
    private final BufferedReader socketIn;
    private String nickname = "anonymous";
    Calendar calendar;
    private List<Integer> timestamp = new ArrayList<Integer>();

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
                    String timestampString = getTimeStamp();
                    if ((line.toLowerCase().startsWith(COMMAND_START_CHAR))) {
                        String command = line.substring(1).toLowerCase();
                        if (command.startsWith(NICK_COMMAND)) {
                            String nickname = command.substring(1 + NICK_COMMAND.length());
                            if (nickname.length() > 0) {
                                this.nickname = nickname;
                            }
                        } else if (command.toLowerCase().startsWith(PRIV_COMMAND)) {
                            String commandWithoutPriv = command.substring(command.indexOf(COMMAND_START_CHAR));
                            String commandWithoutPrivBar = commandWithoutPriv.substring(1);
                            receiverNick = commandWithoutPriv.substring(1, commandWithoutPrivBar.indexOf(COMMAND_START_CHAR) + 1);
                            userMessage = (commandWithoutPrivBar.substring(commandWithoutPrivBar.indexOf(COMMAND_START_CHAR))).substring(1);
                            channel.sendMessage(receiverNick, String.format("[%s]-[%s]-> %s", timestampString, getNickname(), userMessage));
                        }
                    } else {
                        channel.notifyUpdateAll(channel, String.format("[%s]-[%s]: %s", timestampString, getNickname(), line));
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

    /**
     * Gets current timestamp and returns it as a formatted string
     *
     * @return
     */
    public String getTimeStamp() {
        calendar = Calendar.getInstance();
        timestamp.clear();
        timestamp.add(calendar.get(Calendar.HOUR_OF_DAY));
        timestamp.add(calendar.get(Calendar.MINUTE));
        timestamp.add(calendar.get(Calendar.SECOND));
        return String.format("%s:%s:%s", timestamp.get(0), timestamp.get(1), timestamp.get(2));

    }

    @Override
    public void update(Observable o, Object arg) {
        socketOut.println(arg.toString());
    }

    public String getNickname() {
        return nickname;
    }
}
