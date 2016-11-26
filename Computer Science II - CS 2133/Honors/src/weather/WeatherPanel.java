package weather;

import javax.swing.*;
import java.awt.*;


//todo: change set button to change button and remove file menu

class WeatherPanel extends JPanel {

    private WeatherFrame weatherFrame;
    private WeatherMachine weatherMachine;

    private ClothingIcon jacket;
    private ClothingIcon hat;



    WeatherPanel(WeatherFrame weatherFrame, WeatherMachine weatherMachine)
    {
        setLayout(new GridLayout(0,4));

        jacket = new ClothingIcon("jacket.png");
        hat = new ClothingIcon("jacket.png");

        jacket.setEnabled(true);

        add(jacket);
        add(hat);

    }

}


