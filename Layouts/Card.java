import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Card extends JFrame implements ActionListener {

    CardLayout c;
    Container mainPanel;

    Card() {
        mainPanel = getContentPane();
        mainPanel.setLayout(new CardLayout());
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        c = new CardLayout();
        mainPanel.setLayout(c);
        mainPanel.add("1", b3);
        mainPanel.add("2", b2);
        mainPanel.add("3", b1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setVisible(true);
    }

    // abstract method of ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        // CardLayout c = (CardLayout)mainPanel.getLayout();
        this.c.next(mainPanel);
    }

    public static void main(String[] args) {
        new Card();
    }
}
