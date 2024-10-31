package edu.bhcc;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read the cvs file
 * Create a list of Weather objects and store it in a IO file
 */
public class WeatherWriter {
    private File file;
    private ArrayList<Weather> weatherArrayList;

    /**
     * Constructor
     * @param file
     * @param weatherArrayList
     */
    public WeatherWriter(File file, ArrayList<Weather> weatherArrayList) {
        this.file = file;
        this.weatherArrayList = weatherArrayList;
    }
    public void write() throws IOException {
        //  Create the IO Classes
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutputStream);

        //  Write Products to File
        objectOutStream.writeObject(weatherArrayList);

        //  Close when the process finish
        objectOutStream.close();
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        File rawfile = new File("weather.raw");
        File weatherFile = new File("/Users/nguyentran/Library/Mobile Documents/com~apple~CloudDocs/Advance Java/HW4/seattle.csv");
        ArrayList<Weather> weatherArrayList = new ArrayList<>();
        /**
         * Create weather object by scanning through the csv file
         */
        Scanner scanner = new Scanner(weatherFile);
        while (scanner.hasNextLine()){
            String[] line = scanner.nextLine().split(",");

            try {
                double precipitation = Double.parseDouble(line[1]);
                double temp_max = Double.parseDouble(line[2]);
                double temp_min = Double.parseDouble(line[3]);
                double wind = Double.parseDouble(line[4]);
                /**
                 * Create a Weather object whenever the scanner scanned through a line
                 */
                Weather weather = new Weather(precipitation,temp_max,temp_min,wind,line[5]);
                /**
                 * Add new object to the array list after created
                 */
                weatherArrayList.add(weather);


            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
   ;
            }
        WeatherWriter writer = new WeatherWriter(rawfile,weatherArrayList);
        writer.write();
        System.out.println("Write the information into " + rawfile);
        }


    }

