package com.java.observerPattern.singer_crowd;

import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        Singer singer = new Singer("1집", "daye");

        List<Crowd> crowds = IntStream.range(1,10).mapToObj(number -> new Crowd() {
            @Override
            public void gotNewAlbumNotification(Singer singer, String message) {
                String print = String.format("앨범이 나왔어요 [앨범: %s, 가수 %s] %d", singer.getAlbum(), singer.getName(), number);
                System.out.println(print);
            }

            @Override
            public void update(Observable o, Object arg) {
                Singer nameOfSinger = (Singer) o;
                String message = (String) arg;
                gotNewAlbumNotification(nameOfSinger, message);
            }
        }).collect(Collectors.toList());


        IntStream.range(0, crowds.size()).forEach( i ->{
            singer.addObserver(crowds.get(i));
        });
        singer.releasedNewAlbum("새 앨범이 나왔어요");
    }
}
