import javax.swing.*;
import java.awt.*;

public class MinesweeperPanel extends JPanel {

    public MinesweeperPanel() {
        MineModel Game = new MineModel();
        setLayout(new GridLayout(Game.board.length,Game.board.length));

        for(int i = 0; i < Game.board.length; i++)
        {
            for (int j = 0; j < Game.board.length; j++)
            {
                add(Game.board[i][j]);
            }
        }

    }

    public static void GameOverMessage()
    {
        JOptionPane.showMessageDialog(null, "You lose. GG.");
    }
}