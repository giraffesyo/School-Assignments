package weather;

import javax.swing.*;
import java.awt.event.*;

class zipPanel extends JPanel {

    private JLabel zipCodeLabel;
    private JTextField zipEntry;
    private JButton setButton;


    private WeatherFrame weatherFrame;
    private WeatherMachine weatherMachine;
    private WeatherPanel weatherPanel;

    zipPanel(WeatherFrame weatherFrame, WeatherMachine weatherMachine, WeatherPanel weatherPanel) {
        weatherFrame.setZipPanel(this);

        this.weatherFrame = weatherFrame;
        this.weatherMachine = weatherMachine;
        this.weatherPanel = weatherPanel;

        //Setup for Zip Code Box
        this.zipEntry = new JTextField(Integer.toString(weatherMachine.getZipCode()));
        this.zipEntry.addKeyListener(new keyEvent());
        this.setButton = new JButton("Set");
        this.setButton.addActionListener(new actionEvent());
        add((new JLabel("Zip Code:")));

        if (weatherMachine.getProgramState() == 1) {
            addZipCodeLabel();
        } else {
            addZipCodeEntry();
        }
    }

    private void addZipCodeLabel() {
        zipCodeLabel = new JLabel(Integer.toString(weatherMachine.getZipCode()));
        zipCodeLabel.addMouseListener(new mouseEvent());
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
        weatherFrame.sendNotification("Zip Code should be 5 digits.");
    }

    private void invalidString() {
        weatherFrame.sendNotification("Zip Code can only contain numbers.");
    }

    private void invalidDigitsAndString() {
        weatherFrame.sendNotification("Zip code should be 5 digits and contain only numbers.");
    }

    private void zipAction() {

        if(Main.debug){
            System.out.println("zipEntry.getText() result: " + zipEntry.getText());
        }

        String zipText = zipEntry.getText();
        if (zipValid(zipText)) {
            weatherMachine.setZipCode(Integer.parseInt(zipText));
            switchLabels();
            weatherPanel.disableAll();
            weatherPanel.enableIcons();
        } else {
            notifyWrongZip(zipText);
        }

    }

    private void notifyWrongZip(String zipText) {
        if(Main.debug){
            System.out.println("notifyWrongZip() called with " + zipText);
        }
        if (zipText.length() != 5 && !zipText.matches("[0-9]+")) {
            invalidDigitsAndString();
        } else if (zipText.length() != 5) {
            invalidDigits();
        } else if (!zipText.matches("[0-9]+")) {
            invalidString();
        }
    }


    private class mouseEvent extends MouseAdapter{
        //Enable double click for label
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                switchLabels();
            }
        }
    }

    private class actionEvent implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Set")) {
                zipAction();
            }
        }
    }

   private class keyEvent extends KeyAdapter
   {
       @Override
       public void keyPressed(KeyEvent e) {
           if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               zipAction();
           }
       }
   }
}
