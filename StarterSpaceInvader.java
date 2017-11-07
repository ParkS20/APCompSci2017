 import javax.swing.JFrame;

public class StarterSpaceInvader extends JFrame {

    public StarterSpaceInvader()
    {
        add(new BoardSpace());
        setTitle("Board");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new StarterSpaceInvader();
    }
}