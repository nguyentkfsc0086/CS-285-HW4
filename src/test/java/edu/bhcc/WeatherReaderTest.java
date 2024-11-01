package edu.bhcc;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WeatherReaderTest {
    /**
     * This test is fail because I can not make the assertEqual work with object
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testReader1() throws IOException, ClassNotFoundException {
        File file = new File("/Users/nguyentran/Library/Mobile Documents/com~apple~CloudDocs/Advance Java/HW4/weather.raw");
        WeatherReader reader = new WeatherReader(file);
        Weather weather1 = new Weather(0.0,12.8,5.0, 4.7,"drizzle");
        /**
         * Need to discuss with professor about compare 2 Objects
         */
        ArrayList<Weather> list = reader.getWeatherArrayList();
        assertEquals(weather1,list.get(0));
    }
    @Test
    public void testReader2() throws IOException, ClassNotFoundException{
        File file = new File("/Users/nguyentran/Library/Mobile Documents/com~apple~CloudDocs/Advance Java/HW4/weather.raw");
        WeatherReader reader = new WeatherReader(file);
        ArrayList<Weather> weatherArrayList = reader.getWeatherArrayList();
        assertEquals(0.0, weatherArrayList.get(0).getPrecipitation());
    }


}