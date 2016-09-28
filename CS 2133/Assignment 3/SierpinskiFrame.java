import javax.swing.*;
import java.awt.*;

/**
 * Created by mmcquad on 9/27/16.
 */

public class SierpinskiFrame extends JFrame {

    SierpinskiFrame(){
        super("Sierpinski Triangle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setBounds(kit.getScreenSize().width/2,kit.getScreenSize().height/4,800,600); //change to fullscreen

        add(new SierpinskiPanel());
        setVisible(true);


    }
}
