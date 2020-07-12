package com.java.designPattern.adapterPattern;

public class MKV implements MediaPackage {
    @Override
    public void playFile(String filename) {
        System.out.println("playing MKV file"+ filename);
    }
}
