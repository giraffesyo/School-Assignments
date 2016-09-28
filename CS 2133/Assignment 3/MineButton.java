import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MineButton extends JButton {
    public boolean bomb;
    public int nearbyBombCount;

    MineButton(MineModel game) {
        super();
        nearbyBombCount = 0;
        bomb = MineModel.createBomb();
        //int nearbyBombs = //
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(game.isPlaying) {
                    game.onMove(MineButton.this);

                }
            }
        });


    }
}

