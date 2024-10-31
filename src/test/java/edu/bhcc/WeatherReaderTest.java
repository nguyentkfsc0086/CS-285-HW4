package edu.bhcc;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WeatherReaderTest {
    @Test
    public void testReader() throws IOException, ClassNotFoundException {
        File file = new File("/Users/nguyentran/Library/Mobile Documents/com~apple~CloudDocs/Advance Java/HW4/weather.raw");
        WeatherReader reader = new WeatherReader(file);
        Weather weather1 = new Weather(0.0,12.8,5.0, 4.7,"drizzle");

        ArrayList<Weather> list = reader.getWeatherArrayList();
        assertEquals(weather1,list.get(1));
    }

}