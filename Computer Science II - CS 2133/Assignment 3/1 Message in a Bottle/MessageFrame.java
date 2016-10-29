import javax.swing.*;

/**
 * Created by giraffe on 9/21/2016.
 */
public class MessageFrame extends JFrame {
    public MessageFrame()
    {
        super("Message in a Bottle");
        add(new MessagePanel());
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }



public static void main(String[] args)
{
    new MessageFrame();
}
}
