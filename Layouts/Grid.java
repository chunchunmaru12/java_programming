import java.awt.*;
import javax.swing.*;

public class Grid{
    JFrame f;
    Grid(){
        f=new JFrame();
        
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.setLayout(new GridLayout(2,3,10,10));
        f.setSize(300,300);
        f.setVisible(true);
        
    }
    public static void main(String[] args) {
        new Grid();
    }
}