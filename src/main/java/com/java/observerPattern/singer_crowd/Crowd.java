package com.java.observerPattern.singer_crowd;

import java.util.Observer;

public interface Crowd extends Observer {
    void gotNewAlbumNotification(Singer singer, String message);
}
