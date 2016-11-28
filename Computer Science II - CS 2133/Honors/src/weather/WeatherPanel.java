package weather;

import javax.swing.*;
import java.awt.*;

class WeatherPanel extends JPanel {

    private WeatherFrame weatherFrame;
    private WeatherMachine weatherMachine;

    private ClothingIcon hoodie;
    private ClothingIcon snowhat;
    private ClothingIcon tshirt;
    private ClothingIcon shorts;
    private ClothingIcon sweater;
    private ClothingIcon gloves;
    private ClothingIcon boots;
    private ClothingIcon sandals;
    private ClothingIcon raincoat;
    private ClothingIcon umbrella;



    WeatherPanel(WeatherFrame weatherFrame, WeatherMachine weatherMachine)
    {
        this.weatherFrame = weatherFrame;
        this.weatherMachine = weatherMachine;

        setLayout(new GridLayout(0,5));

        hoodie = new ClothingIcon("resources/hoodie.png");
        snowhat = new ClothingIcon("resources/snowhat.png");
        tshirt = new ClothingIcon("resources/tshirt.png");
        shorts = new ClothingIcon("resources/shorts.png");
        sweater = new ClothingIcon("resources/sweater.png");
        gloves = new ClothingIcon("resources/gloves.png");
        boots = new ClothingIcon("resources/boots.png");
        sandals = new ClothingIcon("resources/sandals.png");
        raincoat = new ClothingIcon("resources/raincoat.png");
        umbrella = new ClothingIcon("resources/umbrella.png");

        add(hoodie);
        add(snowhat);
        add(tshirt);
        add(shorts);
        add(sweater);
        add(gloves);
        add(boots);
        add(sandals);
        add(raincoat);
        add(umbrella);

        enableIcons();
    }

    void disableAll()
    {
        hoodie.setEnabled(false);
        snowhat.setEnabled(false);
        tshirt.setEnabled(false);
        shorts.setEnabled(false);
        sweater.setEnabled(false);
        gloves.setEnabled(false);
        boots.setEnabled(false);
        sandals.setEnabled(false);
        raincoat.setEnabled(false);
        umbrella.setEnabled(false);

    }

    void enableIcons()
    {
        hoodie.setEnabled(weatherMachine.needHoodie());
        snowhat.setEnabled(weatherMachine.needSnowhat());
        tshirt.setEnabled(weatherMachine.needTshirt());
        shorts.setEnabled(weatherMachine.needShorts());
        sweater.setEnabled(weatherMachine.needSweater());
        gloves.setEnabled(weatherMachine.needGloves());
        boots.setEnabled(weatherMachine.needBoots());
        sandals.setEnabled(weatherMachine.needSandals());
        raincoat.setEnabled(weatherMachine.needRaincoat());
        umbrella.setEnabled(weatherMachine.needUmbrella());
    }

}
