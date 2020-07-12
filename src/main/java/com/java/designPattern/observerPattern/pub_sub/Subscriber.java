package com.java.designPattern.observerPattern.pub_sub;

import java.util.Observer;

public interface Subscriber extends Observer {
    void receive(Publisher publisher, String message);
}
