package weather;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WeatherPanel extends JPanel implements ActionListener {

    private WeatherFrame weatherFrame;
    private WeatherMachine weatherMachine;

    private JLabel zipCodeLabel;
    private JTextField zipEntry;
    private JButton setButton;

    private int state;

    WeatherPanel(WeatherFrame weatherFrame, WeatherMachine weatherMachine, int state) {
        this.weatherFrame = weatherFrame;
        this.weatherMachine = weatherMachine;

        this.zipEntry = new JTextField(Integer.toString(weatherMachine.getZipCode()));
        this.setButton = new JButton("Set");
        this.setButton.addActionListener(this);

        add(new JLabel("Zip Code:"));

        if (state == 1) {
            addZipCodeLabel();
        } else {
            addZipCodeEntry();
        }
    }

    private void addZipCodeLabel() {
        //TODO:if null? (object?) zip code prompt for one instead
        zipCodeLabel = new JLabel(Integer.toString(weatherMachine.getZipCode()));
        add(zipCodeLabel);
    }

    private void addZipCodeEntry() {
        add(zipEntry);
        add(setButton);
    }


    void switchLabels() {
        if (state == 1) {
            remove(zipCodeLabel);
            addZipCodeEntry();
            revalidate();
            weatherFrame.repaint();
            state = 0;
        } else if (state == 0) {
            remove(zipEntry);
            remove(setButton);
            addZipCodeLabel();
            revalidate();
            weatherFrame.repaint();
            state = 1;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Set")) {
            weatherMachine.setZipCode(Integer.parseInt(zipEntry.getText()));
            switchLabels();
        }
    }
}
