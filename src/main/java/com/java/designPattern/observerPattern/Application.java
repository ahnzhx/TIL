package com.java.designPattern.observerPattern;

public class Application {
    public static void main(String[] args) {
        Button button = new Button();


        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(Button button) {
                System.out.println(button+ " is clicked");
            }
        });
        button.onClick();
    }
}

