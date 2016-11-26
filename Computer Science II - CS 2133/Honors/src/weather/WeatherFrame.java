package weather;

import javax.swing.*;
import java.awt.*;

class WeatherFrame extends JFrame {

    private WeatherPanel weatherPanel;
    private WeatherMachine weatherMachine;

    private final int width = 500;
    private final int height = 500;

    WeatherPanel getWeatherPanel() {
        return weatherPanel;
    }

    WeatherMachine getWeatherMachine() {
        return weatherMachine;
    }

    WeatherFrame() {
        super("Weather Suggestion");

        weatherMachine = new WeatherMachine();
        weatherPanel = new WeatherPanel(this, weatherMachine, weatherMachine.getProgramState());


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setBounds(toolkit.getScreenSize().width / 4, toolkit.getScreenSize().height / 4, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new WeatherMenuBar(this));

        add(weatherPanel);
        setVisible(true);
    }

}
