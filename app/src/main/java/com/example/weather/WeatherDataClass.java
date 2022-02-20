package com.example.weather;

public class WeatherDataClass {

    private String time;
    private String temprature;
    private String icon;
    private String windSpeed;

    public WeatherDataClass(String time, String temprature, String icon, String windSpeed) {
        this.time = time;
        this.temprature = temprature;
        this.icon = icon;
        this.windSpeed = windSpeed;
    }

    public String getTime() {
        return time;
    }

    public String getTemprature() {
        return temprature;
    }

    public String getIcon() {
        return icon;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTemprature(String temprature) {
        this.temprature = temprature;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
