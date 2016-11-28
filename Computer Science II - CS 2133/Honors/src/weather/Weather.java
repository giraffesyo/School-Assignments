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

    boolean isSnowing() {
        return snowing;
    }

    double getWind() {
        return wind;
    }

    double getTemperature() {
        return temperature;
    }

    boolean isRaining() {

        return raining;
    }

    Weather(final int code, final int wind, final double temperature) {

        this.wind = wind;
        this.temperature = temperature;
        this.code = code;

        //refer to https://openweathermap.org/weather-conditions for codes
        if (code >= 200 && code < 700) {
            if (code >= 600) {
                snowing = true;
            } else {
                raining = true;
            }
        }
    }

    static Weather parseWeatherData(final String rawData) {
        int Code;
        int wind;
        double temperature;

        int beginIndex;
        int endIndex;

        beginIndex = rawData.indexOf("wind") + 15;
        wind = Character.getNumericValue(rawData.charAt(beginIndex));
        beginIndex = rawData.indexOf("temp") + 6;
        endIndex = beginIndex + 5;
        temperature = convertKelvin(Double.parseDouble(rawData.substring(beginIndex, endIndex)));

        beginIndex = rawData.indexOf("id") + 4;
        endIndex = beginIndex + 3;

        Code = Integer.parseInt(rawData.substring(beginIndex, endIndex));

        if (Main.debug) {
            System.out.println("Raw Weather Code: " + Code);
            System.out.println("Raw Wind: " + wind);
            System.out.println("Raw temperature: " + temperature);
        }

        return new Weather(Code, wind, temperature);
    }

    static private double convertKelvin(final double kT) {
        return kT * 9.0 / 5.0 - 459.67;
    }


}
