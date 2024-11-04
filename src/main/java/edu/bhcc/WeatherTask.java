package edu.bhcc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WeatherThread implements Runnable{
    /**
     * Use Socket class so client is able to communicate with sever
     * Use DataInputStream and DataOutputStream to reuse the object that stored in Serializable
     */
    private Socket socket;
    private DataInputStream inputFromClient;
    private DataOutputStream outputToClient;

    /**
     * Constructor
     * @param socket
     * @param inputFromClient
     * @param outputToClient
     */
    public WeatherThread(Socket socket, DataInputStream inputFromClient, DataOutputStream outputToClient) throws IOException {
        this.socket = socket;
        this.inputFromClient = new DataInputStream(socket.getInputStream());
        this.outputToClient = outputToClient;
    }

    @Override
    public void run() {


    }
}
