package com.java.functionalProgramming.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    public static void serverSocketTest() throws IOException {
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));
            while(true){
                System.out.println("[연결 기다림]");
                Socket socket = serverSocket.accept(); // 클라이언트 연결 수락
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("[연결 수락함] " + isa.getHostName());

                byte[] bytes = null;
                String message = null;

                InputStream inputStream = socket.getInputStream();
                bytes = new byte[100];

                // 상대방이 비정상적으로 종료했을 경우 IOException 발생
                int readByteCount = inputStream.read(bytes);

                // 상대방이 정상적으로 socket의 close()를 호출했을 경우
                if(readByteCount == -1){
                    throw new IOException(); // 강제로 IOException 발생시킴
                }

                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("[데이터 받기 성공]"+ message);

                OutputStream outputStream = socket.getOutputStream();
                message = "hello client";
                bytes = message.getBytes("UTF-8");
                outputStream.write(bytes);
                outputStream.flush();
                System.out.println("[데이터 보내기 성공]");

                inputStream.close();
                outputStream.close();
                socket.close();
            }

        } catch (Exception e){

        }

        if(!serverSocket.isClosed()){
            try{
                serverSocket.close();
            }catch (IOException e1){}
        }



    }

    public static void main(String[] args) throws IOException {
        serverSocketTest();
    }
}
