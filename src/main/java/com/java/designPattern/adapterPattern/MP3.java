package com.java.designPattern.adapterPattern;

public class MP3 implements MediaPlayer{
    @Override
    public void play(String filename) {
        System.out.println("playing mp3 file"+ filename);
    }
}
