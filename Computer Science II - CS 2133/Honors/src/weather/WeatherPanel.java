package weather;

import javax.swing.*;
import java.awt.*;


//todo: change set button to change button and remove file menu

class WeatherPanel extends JPanel {

    private WeatherFrame weatherFrame;
    private WeatherMachine weatherMachine;

    private ClothingIcon jacket;
    private ClothingIcon snowhat;
    private ClothingIcon tshirt;
    private ClothingIcon shorts;
    private ClothingIcon sweater;
    private ClothingIcon gloves;
    private ClothingIcon boots;
    private ClothingIcon sandals;



    WeatherPanel(WeatherFrame weatherFrame, WeatherMachine weatherMachine)
    {
        setLayout(new GridLayout(0,4));

        jacket = new ClothingIcon("resources/jacket.png");
        snowhat = new ClothingIcon("resources/snowhat.png");
        tshirt = new ClothingIcon("resources/tshirt.png");
        shorts = new ClothingIcon("resources/shorts.png");
        sweater = new ClothingIcon("resources/sweater.png");
        gloves = new ClothingIcon("resources/gloves.png");
        boots = new ClothingIcon("resources/boots.png");
        sandals = new ClothingIcon("resources/sandals.png");

        jacket.setEnabled(true);

        add(jacket);
        add(snowhat);
        add(tshirt);
        add(shorts);
        add(sweater);
        add(gloves);
        add(boots);
        add(sandals);
    }

    void disableAll()
    {
        jacket.setEnabled(false);
        snowhat.setEnabled(false);
        tshirt.setEnabled(false);
        shorts.setEnabled(false);
        sweater.setEnabled(false);
        gloves.setEnabled(false);
        boots.setEnabled(false);
        sandals.setEnabled(false);
    }
    void enableJacket()
    {
        jacket.setEnabled(true);
    }

    void enableSnowhat()
    {
        jacket.setEnabled(true);
    }

    void enableTshirt()
    {
        tshirt.setEnabled(true);
    }

    void enableShorts()
    {
        shorts.setEnabled(true);
    }

    void enableSweater()
    {
        sweater.setEnabled(true);
    }

    void enableGloves()
    {
        gloves.setEnabled(true);
    }

    void enableBoots()
    {
        boots.setEnabled(true);
    }

    void enableSandals()
    {
        sandals.setEnabled(true);
    }
}
