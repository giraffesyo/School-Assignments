package weather;


import javax.swing.*;
import java.awt.*;

class ClothingIcon extends JLabel {

    private final int imageSize = 50;

    ClothingIcon(final String fileName)
    {
        this.setIcon(createScaledImageIcon(fileName));
        this.setFocusable(false);
        this.setEnabled(false);
    }

    private ImageIcon createScaledImageIcon(final String fileName)
    {
        ImageIcon icon = new ImageIcon(fileName);
        Image img = icon.getImage();

        img = img.getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

}
