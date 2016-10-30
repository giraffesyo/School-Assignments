import javax.swing.*;
import java.awt.*;

public class MinesweeperPanel extends JPanel {
    MineModel Game;
    JMenuBar MenuBar;


    public MinesweeperPanel() {
        Game = new MineModel();
        MenuPanel();
        setLayout(new GridLayout(Game.board.length, Game.board.length));

        for (int i = 0; i < Game.board.length; i++) {
            for (int j = 0; j < Game.board.length; j++) {
                add(Game.board[i][j]);
            }
        }

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


        MenuBar.setLayout(new FlowLayout());

        //File Menu Created
        FileMenu = new JMenu("File");
        FileNew = new JMenuItem("New");
        FileOpen = new JMenuItem("Open");
        FileSave = new JMenuItem("Save");
        FileExit = new JMenuItem("Exit");

        //Add File Menu Items
        FileMenu.add(FileNew);
        FileMenu.add(FileOpen);
        FileMenu.add(FileSave);
        FileMenu.add(FileExit);

        //Add File Menu to Menu Bar
        MenuBar.add(FileMenu);


    }
}