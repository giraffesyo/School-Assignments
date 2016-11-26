package weather;

import javax.swing.*;
import java.awt.*;

class WeatherFrame extends JFrame {

    private MainPanel mainPanel;
    private zipPanel ZipPanel;
    private WeatherMachine weatherMachine;
    private JOptionPane notification;

    private final int width = 500;
    private final int height = 150;

    WeatherFrame() {
        super("Weather Suggestion");

        notification = new JOptionPane();
        weatherMachine = new WeatherMachine();
        mainPanel = new MainPanel(this, weatherMachine);


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setBounds(toolkit.getScreenSize().width / 4, toolkit.getScreenSize().height / 4, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new WeatherMenuBar(this));

        add(mainPanel);
        setVisible(true);
    }

    public void sendNotification(String Message)
    {
        notification.createDialog(this, Message);
    }

    zipPanel getZipPanel() {
        return ZipPanel;
    }

    void setZipPanel(zipPanel ZipPanel) {
        this.ZipPanel = ZipPanel;
    }

    WeatherMachine getWeatherMachine() {
        return weatherMachine;
    }

}
