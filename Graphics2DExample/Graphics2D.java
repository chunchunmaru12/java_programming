package Graphics2DExample;
import Graphics2DExample.MainPanel;
import javax.swing.JFrame;

public class Graphics2D extends JFrame{
    MainPanel mainPanel;
    public Graphics2D(){
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        mainPanel = new MainPanel();
        add(mainPanel);
        pack(); // will set JPanel width and height same as JFRAME
        
        
    }
    public static void main(String[] args) {
        new Graphics2D();
    }
}
