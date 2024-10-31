package edu.bhcc;

import java.io.Serializable;

/**
 * Implement Serializable to store and reuse the object whenever we need
 */
public class Weather implements Serializable {
    private float precipitation, temp_max, temp_min, wind;
    private String weather;

    public Weather(float precipitation, float temp_max, float temp_min, float wind, String weather) {
        this.precipitation = precipitation;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.wind = wind;
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "precipitation=" + precipitation +
                ", temp_max=" + temp_max +
                ", temp_min=" + temp_min +
                ", wind=" + wind +
                ", weather='" + weather + '\'' +
                '}';
    }
}
