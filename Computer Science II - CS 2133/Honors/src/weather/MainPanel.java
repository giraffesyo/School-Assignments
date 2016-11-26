package weather;

import javax.swing.*;
import java.awt.*;

class MainPanel extends JPanel {

    MainPanel(WeatherFrame weatherFrame, WeatherMachine weatherMachine)
    {
        setLayout(new GridLayout(0,1));
        add(new zipPanel(weatherFrame,weatherMachine));
        add(new WeatherPanel(weatherFrame,weatherMachine));
    }
}
