package weather;

import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;

class WeatherMachine {

    //TODO: Implement timer thread, automatically update weather data after 10 minutes and refresh everything.

    private File saveFile;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Weather currentWeather;
    private Long lastTime;
    private int programState;
    private final int waitingPeriod = 600000; // 10 minutes in ms

    private Integer zipCode; //TODO: set this from file or request it if no file

    //todo: refresh weather data if zip code updated

    WeatherMachine() {
        saveFile = new File("weather.osu");


        try {
            if (saveFile.exists()) {
                in = new ObjectInputStream(new FileInputStream(saveFile));
                zipCode = (Integer) in.readObject();
                lastTime = (Long) in.readObject();
                currentWeather = (Weather) in.readObject();
                programState = 1;
                in.close();
                if (System.currentTimeMillis() - lastTime > waitingPeriod) {
                    getWeather();
                }
            } else {
                programState = 0;
                zipCode = 12345;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            //todo: we don't have write access?
        }


        //TODO:check timestamp on most recent weather is less than 10 minutes
        //TODO:if less than ten minutes, load in weather object
        //TODO:if not run getWeather
    }

    /**
     * Updates current weather object with new data
     */
    private void getWeather() {
        try {
            BufferedReader in;

            URL url = new URL(constructRequestURL());
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            in = new BufferedReader(new InputStreamReader(http.getInputStream()));

            String rawWeather = in.readLine();
            currentWeather = Weather.parseWeatherData(rawWeather);

            try {
                this.lastTime = System.currentTimeMillis();
                out = new ObjectOutputStream(new FileOutputStream(saveFile));
                out.writeObject(this.zipCode);
                out.writeObject(this.lastTime);
                out.writeObject(this.currentWeather);
                out.flush();
                out.close();
            } catch (IOException e) {
                //todo: we don't have write access?
            }
        } catch (IOException e) {
            //TODO:do they have internet access?
            e.printStackTrace();
        }
    }

    private String constructRequestURL() {
        final String key = "8dad36c07ab6878db0ee4364f4e83c3d";
        return "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",US&appid=" + key;

    }

    void setZipCode(int zipCode) {
        //Test there is really an update so we don't needlessly update weather data
        if (zipCode != this.zipCode) {
            this.zipCode = zipCode;
            getWeather();
        }

        //TODO: IF new ZipCode != oldZipCode
        //TODO: redo weather panel after setting the zip code (this way we have accurate suggestions)
    }

    int getZipCode() {
        return zipCode;
    }

    int getProgramState() {
        return programState;
    }

    public void setProgramState(int programState) {
        this.programState = programState;
    }
}
