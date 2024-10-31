package edu.bhcc;

public class Weather {
    private float precipitation, temp_max, temp_min, wind;
    private String weather;

    public Weather(float precipitation, float temp_max, float temp_min, float wind, String weather) {
        this.precipitation = precipitation;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.wind = wind;
        this.weather = weather;
    }

    public float getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(float precipitation) {
        this.precipitation = precipitation;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getWind() {
        return wind;
    }

    public void setWind(float wind) {
        this.wind = wind;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
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
