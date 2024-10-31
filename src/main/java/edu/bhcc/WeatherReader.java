package edu.bhcc;

import java.io.*;
import java.util.ArrayList;

/**
 * Read the serializable from the cvs file
 */
public class WeatherReader {
    private final ArrayList<Weather> weatherArrayList;

    /**
     * Constructor
     * @param file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public WeatherReader(File file) throws IOException, ClassNotFoundException{
        /**
         * Create the IO class
         */
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);

        /**
         * Read from the file and store it as weather objects
         * Really appreciate the abstraction
         */
        weatherArrayList = (ArrayList<Weather>) objectOutputStream.readObject();
        objectOutputStream.close();
    }

    public ArrayList<Weather> getWeatherArrayList() {
        return weatherArrayList;
    }

    /**
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
     File file = new File("/Users/nguyentran/Library/Mobile Documents/com~apple~CloudDocs/Advance Java/HW4/weather.raw")  ;
        /**
         * Create a reader object to read the IO file
         */
     WeatherReader reader = new WeatherReader(file);
        /**
         * Store the object into an arraylist after finish reading the IO file
         */
     ArrayList<Weather> weatherArrayList = reader.getWeatherArrayList();

    }
}
