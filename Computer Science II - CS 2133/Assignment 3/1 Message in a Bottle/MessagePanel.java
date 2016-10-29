import javax.swing.*;
import java.awt.*;

/**
 * Created by giraffe on 9/22/2016.
 */
public class MessagePanel extends JPanel {

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        int WINDOW_H = getHeight();
        int WINDOW_W = getWidth();

        //SIDES Y VALUE
        int SIDE_START = WINDOW_H/2;
        int SIDE_LENGTH = WINDOW_H/2 + (WINDOW_H / 2 - WINDOW_H / 4);

        //SIDES X VALUE
        int LEFT_SIDE = WINDOW_W/4;
        int RIGHT_SIDE = WINDOW_W/2;

        int BOTTOM_ARC_HEIGHT = WINDOW_H / 25;
        int TOP_ARC_HEIGHT = WINDOW_H / 100;

        //TOP
        int QUARTER_OF_BOTTLE_LEFT = LEFT_SIDE + ((RIGHT_SIDE - LEFT_SIDE) / 4);
        int QUARTER_OF_BOTTLE_RIGHT = LEFT_SIDE + (((RIGHT_SIDE - LEFT_SIDE) /4)* 3);
        int TOP_LENGTH = LEFT_SIDE - ( WINDOW_H / 20);

        //Bottle Left Side
        g.drawLine(LEFT_SIDE,SIDE_START,LEFT_SIDE,SIDE_LENGTH);
        //Bottle Right Side
        g.drawLine(RIGHT_SIDE,SIDE_START,RIGHT_SIDE, SIDE_LENGTH);
        //BOTTLE BOTTOM
        g.drawArc(LEFT_SIDE, SIDE_LENGTH - BOTTOM_ARC_HEIGHT/(2), RIGHT_SIDE - LEFT_SIDE, BOTTOM_ARC_HEIGHT, 180, 180);
        //BOTTLE TOP LEFT
        g.drawLine(LEFT_SIDE, SIDE_START, QUARTER_OF_BOTTLE_LEFT, TOP_LENGTH);
        //BOTTLE TOP RIGHT
        g.drawLine(RIGHT_SIDE, SIDE_START, QUARTER_OF_BOTTLE_RIGHT, TOP_LENGTH);

        g.drawOval(QUARTER_OF_BOTTLE_LEFT,TOP_LENGTH,QUARTER_OF_BOTTLE_RIGHT - QUARTER_OF_BOTTLE_LEFT, TOP_ARC_HEIGHT);

        g.drawString("Message in a Bottle",QUARTER_OF_BOTTLE_LEFT, SIDE_START);
    }
}
