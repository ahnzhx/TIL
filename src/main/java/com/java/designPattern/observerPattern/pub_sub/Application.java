package com.java.designPattern.observerPattern.pub_sub;

import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        Publisher publisher1 = new Publisher("발행자1");
        Publisher publisher2 = new Publisher("발행자2");

        List<Subscriber> subscribers= IntStream.range(1,11).mapToObj(number -> new Subscriber() {
            @Override
            public void receive(Publisher publisher, String message) {
                String print = String.format("[구독자%d: 보낸사람 %s]:%s", number, publisher.getName(), message);
                System.out.println(print);
            }

            @Override
            public void update(Observable o, Object arg) {
                Publisher p = (Publisher) o;
                String message = (String) arg;
                receive(p, message);
            }
        }).collect(Collectors.toList());

        IntStream.range(0, subscribers.size())
                .forEach( i->{
                    if(i%2 == 0){
                        publisher1.addSubscriber(subscribers.get(i));
                    }else{
                        publisher2.addSubscriber(subscribers.get(i));
                    }
                });
        publisher1.send("메시지1");
        publisher2.send("메시지2");
    }
}
