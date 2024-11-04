package edu.bhcc;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

public class WeatherTask implements Runnable{

    private Socket socket;
    private BufferedReader inputFromClient;
    private ObjectOutputStream outputToClient;

    public WeatherTask(Socket socket) throws IOException, ClassNotFoundException {
        this.socket = socket;
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        this.inputFromClient = new BufferedReader(inputStreamReader);
        this.outputToClient = new ObjectOutputStream(socket.getOutputStream());

    }


    @Override
    public void run() {



    }
}
