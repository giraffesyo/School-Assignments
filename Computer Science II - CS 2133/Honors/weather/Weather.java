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

    Weather(final String rawData) {
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


        //refer to https://openweathermap.org/weather-conditions for codes
        if (Code >= 200 && Code < 700) {
            if (Code >= 600) {
                snowing = true;
            } else {
                raining = true;
            }
        }

        this.wind = wind;
        this.temperature = temperature;
    }



    static private double convertKelvin(final double kT) {
        return kT * 9.0 / 5.0 - 459.67;
    }


}
