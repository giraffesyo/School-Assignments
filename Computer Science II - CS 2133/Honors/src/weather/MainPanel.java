package weather;

import javax.swing.*;

class MainPanel extends JPanel {

    MainPanel(WeatherFrame weatherFrame, WeatherMachine weatherMachine)
    {

        WeatherPanel weatherPanel = new WeatherPanel(weatherFrame, weatherMachine);
        zipPanel ZipPanel = new zipPanel(weatherFrame, weatherMachine, weatherPanel);
        //setLayout(new GridLayout(0,1));
        add(ZipPanel);
        add(weatherPanel);
    }
}
