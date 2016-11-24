package weather;

import javax.swing.*;

class WeatherPanel extends JPanel {

    private WeatherFrame weatherFrame;
    private WeatherMachine weatherMachine;

    private JLabel zipCodeLabel;
    private JTextField zipEntry;

    private int state;

    WeatherPanel(WeatherFrame weatherFrame, WeatherMachine weatherMachine) {
        this.weatherFrame = weatherFrame;
        this.weatherMachine = weatherMachine;
        add(new JLabel("Zip Code:"));

        zipEntry = new JTextField();
        addZipCodeLabel();
    }

    void addZipCodeLabel()
    {
        //TODO:if null? (object?) zip code prompt for one instead
        zipCodeLabel = new JLabel(Integer.toString(weatherMachine.getZipCode()));
        add(zipCodeLabel);
        state = 1;
    }

    void switchLabels()
    {
        if (state == 1){
            remove(zipCodeLabel);
            add(zipEntry);
            repaint();
            state = 0;
        }
        else if (state == 0)
        {
            remove(zipEntry);
            addZipCodeLabel();
            repaint();
            state = 1;
        }
    }
}
