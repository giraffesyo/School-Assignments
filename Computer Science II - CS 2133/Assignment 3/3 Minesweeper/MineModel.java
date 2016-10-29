import java.util.Random;


public class MineModel {
    final static int GridSize = 10;
    public static boolean isPlaying = true;
    public MineButton board[][];
    final static int BombChance = 3; //higher number == less bombs


    public MineModel() {
        board = generateBoard();
        nearbyBombs();
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
                   board[i][j].setText("Bomb!");
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
            ButtonPressed.setText("BOMB!");
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

}


