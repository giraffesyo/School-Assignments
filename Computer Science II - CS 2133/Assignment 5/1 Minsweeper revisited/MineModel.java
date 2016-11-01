import javax.swing.*;
import java.io.*;
import java.util.Random;


public class MineModel {
    static int GridSize = 5;
    public static boolean isPlaying = true;
    public MineButton board[][];
    static int BombChance = 3; //higher number == less bombs
    public MinesweeperFrame frame;


    public MineModel(MinesweeperFrame frame, MinesweeperPanel panel) {

        this.frame = frame;
        newGame(1, panel);
    }
    public static boolean createBomb() {
        Random RandomNumber = new Random();
        return ((RandomNumber.nextInt() % BombChance) == 0);

    }

    public void loseGame() {
        isPlaying = false;
        MinesweeperPanel.GameOverMessage();
        for (int i = 0; i < GridSize; i++)
            for (int j = 0; j <GridSize; j++)
                if(board[i][j].bomb)
                   board[i][j].displayIcon();
                else
                    board[i][j].setText(Integer.toString(board[i][j].nearbyBombCount));
    }


    private MineButton[][] generateBoard() {
        MineButton[][] MineButtons = new MineButton[GridSize][GridSize];
        for (int i = 0; i < GridSize; i++) {
            for (int j = 0; j < GridSize; j++) {
                MineButtons[i][j] = new MineButton(this);
            }
        }
        return MineButtons;
    }


    private void nearbyBombs() {
        for (int i = 0; i < GridSize; i++) {
            for (int j = 0; j < GridSize; j++) {
                //top
                if (i > 0 && j > 0) {
                    if (board[i - 1][j - 1].bomb)
                        board[i ][j].nearbyBombCount++;
                }
                if (j > 0) {
                    if (board[i][j - 1].bomb)
                        board[i][j].nearbyBombCount++;
                    if (i < GridSize - 1) {
                        if (board[i + 1][j - 1].bomb)
                            board[i][j].nearbyBombCount++;
                    }
                }
                //center
                if (i > 0) {
                    if (board[i - 1][j].bomb)
                        board[i ][j].nearbyBombCount++;
                }
                if (i < GridSize - 1) {
                    if (board[i + 1][j].bomb)
                        board[i][j].nearbyBombCount++;
                }
                //Bottom
                if (i > 0) {
                    if (j < GridSize - 1) {
                        if (board[i - 1][j + 1].bomb)
                            board[i][j].nearbyBombCount++;
                    }
                }
                if (j < GridSize - 1) {
                    if (board[i][j + 1].bomb)
                        board[i][j].nearbyBombCount++;
                }
                if (i < GridSize - 1 && j < GridSize - 1) {
                    if (board[i + 1][j + 1].bomb)
                        board[i][j].nearbyBombCount++;
                }
            }
        }

        }


    public void onMove(MineButton ButtonPressed) {
        if(ButtonPressed.bomb){
            ButtonPressed.displayIcon();
            loseGame();
        }
        else
        {
            ButtonPressed.setText(Integer.toString(ButtonPressed.nearbyBombCount));
        }
    }

    public void onRightClick(MineButton ButtonPressed) {
        if (!ButtonPressed.flagged) {
            ButtonPressed.setText("Flag");
            ButtonPressed.flagged = true;
        }
        else
        {
            ButtonPressed.setText("");
            ButtonPressed.flagged = false;
        }
    }

    public void newGame(int difficulty, MinesweeperPanel panel)
    {
        switch (difficulty) {
            case 1: GridSize = 5;
                break;
            case 2: GridSize = 10;
                break;
            case 3: GridSize = 15;
                break;
        }
        panel.removeAll();
        board = generateBoard();
        nearbyBombs();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                panel.add(board[i][j]);
            }
        }
        isPlaying = true;
        panel.revalidate();
        frame.repaint();
    }

    public void newGame(MineButton[][] board, MinesweeperPanel panel)
    {
        panel.removeAll();
        this.board = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                panel.add(board[i][j]);
            }
        }
        isPlaying = true;
        panel.revalidate();
        frame.repaint();
    }

    public void saveGame(File selectedFile)
    {
        try{
            FileOutputStream saveFile = new FileOutputStream(selectedFile);
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(board);
            save.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadGame(File selectedFile, MinesweeperPanel panel)
    {
        try{
            FileInputStream saveFile = new FileInputStream(selectedFile);
            ObjectInputStream save = new ObjectInputStream(saveFile);
            newGame((MineButton[][])save.readObject(), panel);
            save.close();

        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }


}


