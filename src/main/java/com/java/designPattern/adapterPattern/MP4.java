package com.java.designPattern.adapterPattern;

public class MP4 implements MediaPackage{
    @Override
    public void playFile(String filename) {
        System.out.println("playing mp4 file"+ filename);
    }
}
