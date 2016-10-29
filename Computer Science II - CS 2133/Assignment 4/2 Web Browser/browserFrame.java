import javax.swing.*;
import java.awt.*;

public class browserFrame extends JFrame {
    browserFrame(){
        super("A very simple web browser");
        Toolkit kit = Toolkit.getDefaultToolkit();
        setSize(kit.getScreenSize().width/2,kit.getScreenSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new browserPanel(this));
        setVisible(true);
    }


}
