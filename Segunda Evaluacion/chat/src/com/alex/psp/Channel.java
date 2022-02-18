package com.alex.psp;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class Channel extends Observable {
    private List<PeerConnection> observers;
    private List<PeerConnection> notifiedObservers;

    public Channel() {
        observers = new ArrayList<>();
        notifiedObservers = new ArrayList<>();
    }

    @Override
    public void notifyObservers(Object arg) {

        setChanged();
        super.notifyObservers(arg);
    }

    public void addObserverToArray(PeerConnection observer) {
        observers.add(observer);
    }
    /**
     * Calls all the observers and updates them
     *
     * @param obs
     * @param obj
     */
    public void notifyUpdateAll(Observable obs, Object obj) {
        for (Observer o : observers) {
            o.update(obs, obj);
        }
    }

    /**
     * Update only the observers using the nickname parameter, used in sendMessage();
     *
     * @param obs
     * @param obj
     */
    public void notifyUpdate(Observable obs, Object obj) {
        for (Observer o : notifiedObservers) {
            o.update(obs, obj);
        }
    }

    /**
     * Method which calls one observer or another depending on the size of the
     * nofifiedObservers array, which will grow if we use /priv/nick/message command and
     * there are users with the given nick
     * @param nickname
     * @param message
     */
    public void sendMessage(String nickname, String message) {
        notifiedObservers.clear();
        for (int i = 0; i < observers.size(); i++) {
            if (observers.get(i).getNickname().equals(nickname)) {
                notifiedObservers.add(observers.get(i));
            }
        }
        if (notifiedObservers.size() > 0) {
            notifyUpdate(this, message);
        } else {
            notifyUpdateAll(this, message);
        }
    }
}
