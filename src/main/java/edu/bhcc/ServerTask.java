package edu.bhcc;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class WeatherTask implements Runnable{
    /**
     * Use Socket class so client is able to communicate with sever
     * Use DataInputStream and DataOutputStream to reuse the object that stored in Serializable
     */
    private Socket socket;
    private BufferedReader inputFromClient;
    private ObjectOutputStream outputToClient;
    private File file;
    private HashMap<String,Weather> hashMap;


    /**
     * Constructor
     * @param socket
     */
    public WeatherTask(Socket socket) throws IOException, ClassNotFoundException {
        this.socket = socket;
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        this.inputFromClient = new BufferedReader(inputStreamReader);
        this.outputToClient = new ObjectOutputStream(socket.getOutputStream());
        this.file = new File("/Users/nguyentran/Library/Mobile Documents/com~apple~CloudDocs/Advance Java/HW4/weather.raw");
        this.hashMap = new WeatherReader(file).getWeatherHashMap();
    }

    @Override
    public void run() {
        /**
         * Recive the input from client
         */
        try {
            String intput = inputFromClient.readLine();
            if(hashMap.containsKey(intput)){
                Weather result = hashMap.get(intput);
                outputToClient.writeChars(result.toString());
                outputToClient.flush();
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
