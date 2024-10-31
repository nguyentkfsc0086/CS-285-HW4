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
}
