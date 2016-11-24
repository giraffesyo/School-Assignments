package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

class WeatherMachine {


    private Weather currentWeather;

    private int zipCode; //TODO: set this from file or request it if no file

    //todo: refresh weather data if zip code updated

    WeatherMachine() {

        zipCode = 74075;
        //TODO:check timestamp on most recent weather is less than 10 minutes
        //TODO:if less than ten minutes, load in weather object
        //TODO:if not run getWeather
    }

    /**
     * Updates current weather object with new data
     */
    private void getWeather()
    {
        try {
            BufferedReader in;

            URL url = new URL(constructRequestURL());
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            in = new BufferedReader( new InputStreamReader(http.getInputStream()));

            String rawWeather = in.readLine();
            currentWeather = Weather.parseWeatherData(rawWeather);
        }
        catch(IOException e)
        {
            //TODO:do they have internet access?
            e.printStackTrace();
        }
    }

    private String constructRequestURL()
    {
        final String key = "8dad36c07ab6878db0ee4364f4e83c3d";
        return "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",US&appid=" + key;

    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getZipCode() {
        return zipCode;
    }
}
