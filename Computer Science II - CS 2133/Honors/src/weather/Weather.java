package weather;

import java.io.Serializable;

/**
 * Data object storing weather information
 */
class Weather implements Serializable {

    private boolean raining;
    private boolean snowing;
    private final int wind; //skirts? umbrella?
    private final double temperature;
    private final int code;

    public boolean isSnowing() {
        return snowing;
    }

    public double getWind() {
        return wind;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isRaining() {

        return raining;
    }

    Weather(final int code, final int wind, final double temperature) {
        boolean precipitation;
        this.wind = wind;
        this.temperature = temperature;
        this.code = code;

        //refer to https://openweathermap.org/weather-conditions for codes
        if ( code >= 200 && code < 800 )
            precipitation = true;
        else
            precipitation = false;

        //we cant be raining below 32 degrees, right?
        if (precipitation) {
            if (temperature < 32)
                snowing = true;
            else
                raining = true;
        }

    }

    static Weather parseWeatherData(final String rawData)
    {
        int Code;
        int wind;
        double temperature;

        int beginIndex;
        int endIndex;

        beginIndex =rawData.indexOf("wind") + 15;
        wind = Character.getNumericValue(rawData.charAt(beginIndex));
        beginIndex = rawData.indexOf("temp") + 6;
        endIndex = beginIndex + 5;
        temperature = convertKelvin(Double.parseDouble(rawData.substring(beginIndex,endIndex)));

        beginIndex = rawData.indexOf("id") + 4;
        endIndex = beginIndex + 2;

        Code = Integer.parseInt(rawData.substring(beginIndex,endIndex));

        return new Weather(Code ,wind,temperature);
    }

    static private double convertKelvin(final double kT)
    {
        return kT * 9.0/5.0 - 459.67;
    }


}
