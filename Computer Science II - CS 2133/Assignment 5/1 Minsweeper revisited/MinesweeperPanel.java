import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MinesweeperPanel extends JPanel implements ActionListener {
    MineModel Game;
    JMenuBar MenuBar;
    MinesweeperFrame frame;
    JFileChooser fc;

    public MinesweeperPanel(MinesweeperFrame frame) {
        this.frame = frame;
        fc = new JFileChooser(".");
        fc.setSelectedFile(new File("Minesweeper.sav"));
        fc.setFileFilter(new FileNameExtensionFilter("Minesweeper Save Games", "sav"));
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
        JMenu FileNew;
        JMenuItem FileOpen;
        JMenuItem FileSave;
        JMenuItem FileExit;
        JMenuItem NewBeginner;
        JMenuItem NewIntermediate;
        JMenuItem NewAdvanced;

        //File Menu Created
        FileMenu = new JMenu("File");
        FileMenu.addActionListener(this);
        FileNew = new JMenu("New");
        FileOpen = new JMenuItem("Open");
        FileOpen.addActionListener(this);
        FileSave = new JMenuItem("Save");
        FileSave.addActionListener(this);
        FileExit = new JMenuItem("Exit");
        FileExit.addActionListener(this);

        //FileNew menu Created
        NewBeginner = new JMenuItem("Beginner");
        NewBeginner.addActionListener(this);
        NewIntermediate = new JMenuItem("Intermediate");
        NewIntermediate.addActionListener(this);
        NewAdvanced = new JMenuItem("Advanced");
        NewAdvanced.addActionListener(this);

        //Add difficulties to FileNew menu
        FileNew.add(NewBeginner);
        FileNew.add(NewIntermediate);
        FileNew.add(NewAdvanced);

        //Add File Menu components to File Menu
        FileMenu.add(FileNew);
        FileMenu.add(FileOpen);
        FileMenu.add(FileSave);
        FileMenu.add(FileExit);

        //Add File Menu to Menu Bar
        MenuBar.add(FileMenu);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Beginner")) {
            frame.setSize(150, 150);
            Game.newGame(1, this);
        } else if (e.getActionCommand().equals("Intermediate")) {
            frame.setSize(500, 150);
            Game.newGame(2, this);
        } else if (e.getActionCommand().equals("Advanced")) {
            frame.setSize(1260, 150);
            Game.newGame(3, this);
        } else if (e.getActionCommand().equals("Open")) {
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                Game.loadGame(fc.getSelectedFile(), this);
            }
        } else if (e.getActionCommand().equals("Save")) {
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                Game.saveGame(fc.getSelectedFile());
            }
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }


}

