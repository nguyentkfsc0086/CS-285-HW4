package edu.bhcc;

import java.io.Serializable;

/**
 * Implement Serializable to store and reuse the object whenever we need
 */
public class Weather implements Serializable, Comparable<Weather>{
    private double precipitation, temp_max, temp_min, wind;
    private String weather;

    public Weather(double precipitation, double temp_max, double temp_min, double wind, String weather) {
        this.precipitation = precipitation;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.wind = wind;
        this.weather = weather;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getWind() {
        return wind;
    }

    public String getWeather() {
        return weather;
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

    /**
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Weather o) {
        if(this.precipitation == o.precipitation &&
            this.temp_max == o.temp_max &&
            this.temp_min == o.temp_min &&
            this.wind == o.wind &&
            this.weather.equals(o.weather)){
        return 0;
        }
        return 1;

    }
}
