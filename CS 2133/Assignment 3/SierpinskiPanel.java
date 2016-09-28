import javax.swing.*;
import java.awt.*;

/**
 * Created by mmcquad on 9/27/16.
 */
public class SierpinskiPanel extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int sizeScreen = width;

        if(sizeScreen < height){
            sizeScreen = height;
        }
        drawSierpinski(g,0,0,sizeScreen); //add dimensions and coords
    }
    public void drawSierpinski(Graphics g, int coordinateX, int coordinateY, int sizeScreen)
    {

        int leftX = coordinateX + sizeScreen/ 4;
        int leftY = coordinateY + sizeScreen / 2;
        int drawSize = sizeScreen / 2;
        int rightX = coordinateX + sizeScreen / 2;


        if(sizeScreen == 1) {
            g.fillRect(coordinateX,coordinateY,sizeScreen,sizeScreen);
        }
        else{
            drawSierpinski(g, leftX, coordinateY, drawSize);
            drawSierpinski(g, coordinateX, leftY, drawSize);
            drawSierpinski(g, rightX, leftY,drawSize);
        }
    }
}
