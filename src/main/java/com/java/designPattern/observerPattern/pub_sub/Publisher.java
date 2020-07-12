package com.java.designPattern.observerPattern.pub_sub;

import java.util.Arrays;
import java.util.Observable;

public class Publisher extends Observable {
    private String name;

    public String getName() {
        return name;
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher(Subscriber... subscribers){
        addSubscribers(subscribers);
    }

    public void addSubscribers(Subscriber... subscribers){
        Arrays.stream(subscribers).forEach(this::addObserver);
    }

    public void addSubscriber(Subscriber subscriber){
        addObserver(subscriber);
    }

    public void send(String message){
        setChanged();
        notifyObservers(message);
    }
}
