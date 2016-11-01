import javax.swing.*;
import java.awt.*;

public class MinesweeperFrame extends JFrame {

    MinesweeperFrame(){
        super("Minesweeper");
        Toolkit kit = Toolkit.getDefaultToolkit();
        setBounds(kit.getScreenSize().width/4, kit.getScreenSize().height/4, 150, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MinesweeperPanel MinePanel = new MinesweeperPanel(this);
        setJMenuBar(MinePanel.MenuBar);
        add(MinePanel);
        setVisible(true);
    }
}
