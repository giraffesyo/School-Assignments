package weather;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WeatherMenuBar extends JMenuBar implements ActionListener {

    private WeatherFrame weatherFrame;

    private class FileMenu extends JMenu {

        JMenuItem fileLoc;
        JMenuItem fileExit;

        FileMenu() {
            super("File");
            fileLoc = new JMenuItem("Change Location");
            fileExit = new JMenuItem("Exit");

            fileLoc.addActionListener(WeatherMenuBar.this);
            fileExit.addActionListener(WeatherMenuBar.this);

            add(fileLoc);
            add(fileExit);
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Change Location")) {
            if (weatherFrame.getWeatherMachine().getProgramState() == 1) {
                weatherFrame.getWeatherPanel().switchLabels();
            }
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }

    WeatherMenuBar(WeatherFrame weatherFrame) {
        this.weatherFrame = weatherFrame;
        add(new FileMenu());
    }


}
