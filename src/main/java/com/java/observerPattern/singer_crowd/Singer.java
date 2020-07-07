package com.java.observerPattern.singer_crowd;

import java.util.Observable;

public class Singer extends Observable {
    private String album;

    private String name;

    public String getAlbum() {
        return album;
    }

    public String getName() {
        return name;
    }

    public Singer(String album, String name) {
        this.album = album;
        this.name = name;
    }

    public void releasedNewAlbum(String message){
        setChanged();
        notifyObservers(message);
    }
}
