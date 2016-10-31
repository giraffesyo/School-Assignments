import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesweeperPanel extends JPanel implements ActionListener {
    MineModel Game;
    JMenuBar MenuBar;
    MinesweeperFrame frame;

    public MinesweeperPanel(MinesweeperFrame frame) {
        this.frame = frame;

        Game = new MineModel(frame, this);
        MenuPanel();
        setLayout(new GridLayout(Game.board.length, Game.board.length));
    }

    public static void GameOverMessage() {
        JOptionPane.showMessageDialog(null, "You lose. GG.");
    }


    private void MenuPanel() {

        MenuBar = new JMenuBar();
        JMenu FileMenu;
        JMenuItem FileNew;
        JMenuItem FileOpen;
        JMenuItem FileSave;
        JMenuItem FileExit;


        //File Menu Created
        FileMenu = new JMenu("File");
        FileMenu.addActionListener(this);
        FileNew = new JMenuItem("New");
        FileNew.addActionListener(this);
        FileOpen = new JMenuItem("Open");
        FileOpen.addActionListener(this);
        FileSave = new JMenuItem("Save");
        FileSave.addActionListener(this);
        FileExit = new JMenuItem("Exit");
        FileExit.addActionListener(this);


        //Add File Menu components to File Menu
        FileMenu.add(FileNew);
        FileMenu.add(FileOpen);
        FileMenu.add(FileSave);
        FileMenu.add(FileExit);

        //Add File Menu to Menu Bar
        MenuBar.add(FileMenu);


    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("New"))
        {
            Game.newGame(this);
        }
        else if(e.getActionCommand().equals("Open"))
        {

        }
        else if(e.getActionCommand().equals("Save"))
        {

        }
        else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
    }


}

