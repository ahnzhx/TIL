package com.java.observerPattern.pub_sub;

import java.util.Observer;

public interface Subscriber extends Observer {
    void receive(Publisher publisher, String message);
}
