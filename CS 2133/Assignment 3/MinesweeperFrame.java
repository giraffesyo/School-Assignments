import javax.swing.*;
import java.awt.*;

public class MinesweeperFrame extends JFrame {

    MinesweeperFrame(){
        super("Minesweeper");
        Toolkit kit = Toolkit.getDefaultToolkit();
        setBounds(kit.getScreenSize().width/2, kit.getScreenSize().height/4, 800, 600); //change to full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MinesweeperPanel());
        setVisible(true);
    }
}
