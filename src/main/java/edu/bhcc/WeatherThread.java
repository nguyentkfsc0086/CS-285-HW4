package edu.bhcc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WeatherThread implements Runnable{
    /**
     * Use Socket class so client is able to communicate with sever
     * Use DataInputStream and DataOutputStream to reuse the object that stored in Serializable
     */
    private HashMap<String,Weather> weatherHashMap = new HashMap<>();
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

    /**
     * Return the Hash map that contain the date as a key
     */
    public HashMap<String,Weather> getWeatherHashMap(File file) throws IOException, ClassNotFoundException {
        WeatherReader reader = new WeatherReader(file);
        Scanner scanner = new Scanner(file);
        ArrayList<Weather> weatherArrayList = reader.getWeatherArrayList();
        int counter = 0;
        while (scanner.hasNextLine()){
            String[] line = scanner.nextLine().split(",");
            this.weatherHashMap.put(line[0],weatherArrayList.get(counter));
        }
        return this.weatherHashMap;
    }
    @Override
    public void run() {
        File file = new File("/Users/nguyentran/Library/Mobile Documents/com~apple~CloudDocs/Advance Java/HW4/seattle.csv");
        try {
            HashMap<String,Weather> weatherHashMap = getWeatherHashMap(file);
            /**
             * Recive the input from the client
             */
            String input = "";
            for(int i = 0; i < 9; i++){
                input += inputFromClient.readChar();
            }
            /**
             * Check if the hashmap contain the input
             */
            if(weatherHashMap.containsKey(input)){
                Weather output = weatherHashMap.get(input);
                /**
                 * Send result back to client
                 */
                outputToClient.writeChars(output.toString());
                outputToClient.flush();
                socket.close();
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
