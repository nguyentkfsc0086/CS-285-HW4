package edu.bhcc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SeverWeather {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting server at: " + new Date());
        /**
         * Declare the port to communicate between sever and client
         */
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true){
            Socket socket = serverSocket.accept();

        }
    }
}
