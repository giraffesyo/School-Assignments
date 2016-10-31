import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MineButton extends JButton {
    public boolean bomb;
    public int nearbyBombCount;
    public boolean flagged = false;

    MineButton(MineModel game) {
        super();
        nearbyBombCount = 0;
        bomb = MineModel.createBomb();

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(game.isPlaying) {
                    if(SwingUtilities.isRightMouseButton(e)){
                        game.onRightClick(MineButton.this);
                    }
                        else{
                        game.onMove(MineButton.this);
                    }
                }
            }
        });


    }
}

