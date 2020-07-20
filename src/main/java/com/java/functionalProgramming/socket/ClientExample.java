package com.java.functionalProgramming.socket;

import org.hibernate.result.Output;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        socket = new Socket(); // 소켓 생성
        System.out.println("[연결 요청]");
        socket.connect(new InetSocketAddress("localhost", 5001));
        System.out.println("[연결 성공]");

        byte[] bytes = null;
        String message = null;

        OutputStream outputStream = socket.getOutputStream();
        message = "hello server";
        bytes = message.getBytes("UTF-8");
        outputStream.write(bytes);
        outputStream.flush();
        System.out.println("데이터 보내기 성공");

        InputStream inputStream = socket.getInputStream();
        bytes = new byte[100];
        int readByteCount = inputStream.read(bytes);
        message = new String(bytes, 0, readByteCount, "UTF-8");
        System.out.println("데이터 받기 성공:" + message);

        outputStream.close();
        inputStream.close();


        if(!socket.isClosed()){
            socket.close();
        }

    }
}
