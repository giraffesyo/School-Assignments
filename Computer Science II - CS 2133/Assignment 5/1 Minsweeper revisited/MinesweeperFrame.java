import javax.swing.*;
import java.awt.*;

public class MinesweeperFrame extends JFrame {

    MinesweeperFrame(){
        super("Minesweeper");
        Toolkit kit = Toolkit.getDefaultToolkit();
        setBounds(kit.getScreenSize().width/2, kit.getScreenSize().height/4, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MinesweeperPanel MinePanel = new MinesweeperPanel();
        setJMenuBar(MinePanel.MenuBar);
        add(MinePanel);
        setVisible(true);
    }
}
