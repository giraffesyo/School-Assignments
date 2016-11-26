package weather;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//todo: change set button to change button and remove file menu

class WeatherPanel extends JPanel implements ActionListener, KeyListener {

    private WeatherFrame weatherFrame;
    private WeatherMachine weatherMachine;

    private JLabel zipCodeLabel;
    private JTextField zipEntry;
    private JButton setButton;
    private static JOptionPane notification = new JOptionPane(); //if we need to send any messages to the user


    WeatherPanel(WeatherFrame weatherFrame, WeatherMachine weatherMachine, int state) {
        this.weatherFrame = weatherFrame;
        this.weatherMachine = weatherMachine;

        this.zipEntry = new JTextField(Integer.toString(weatherMachine.getZipCode()));
        this.zipEntry.addKeyListener(this);
        this.setButton = new JButton("Set");
        this.setButton.addActionListener(this);

        add(new JLabel("Zip Code:"));

        if (weatherMachine.getProgramState() == 1) {
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
        if (weatherMachine.getProgramState() == 1) {
            remove(zipCodeLabel);
            addZipCodeEntry();
            revalidate();
            weatherFrame.repaint();
            weatherMachine.setProgramState(0);
        } else if (weatherMachine.getProgramState() == 0) {
            remove(zipEntry);
            remove(setButton);
            addZipCodeLabel();
            revalidate();
            weatherFrame.repaint();
            weatherMachine.setProgramState(1);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Set")) {
            zipAction();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            zipAction();
        }
    }

    public void keyReleased(KeyEvent e) {
        //we don't do anything with this.
    }

    public void keyTyped(KeyEvent e)
    {
        //we don't do anything with this.
    }

    /**
     * Tests that zip code contains nothing but numbers and is the right size
     *
     * @param zipText The string of numbers to test
     * @return Returns true if a valid zip code (numbers from 00000-99999)
     */
    private boolean zipValid(String zipText) {
        boolean valid;

        if (zipText.length() == 5 && zipText.matches("[0-9]+")) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }

    private void invalidDigits() {
        notification.showMessageDialog(weatherFrame, "Zip Code should be 5 digits.");
    }

    private void invalidString() {
        notification.showMessageDialog(weatherFrame, "Zip Code can only contain numbers.");
    }

    private void invalidDigitsAndString() {
        notification.showMessageDialog(weatherFrame, "Zip code should be 5 digits and contain only numbers.");
    }

    private void zipAction() {
        String zipText = zipEntry.getText();
        if (zipValid(zipText)) {
            weatherMachine.setZipCode(Integer.parseInt(zipText));
            switchLabels();
        } else {
            notifyWrongZip(zipText);
        }
    }

    private void notifyWrongZip(String zipText) {
        if (zipText.length() != 5 && !zipText.matches("[0-9]+")) {
            invalidDigitsAndString();
        } else if (zipText.length() != 5) {
            invalidDigits();
        } else if (!zipText.matches("[0-9]+")) {
            invalidString();
        }
    }


}
