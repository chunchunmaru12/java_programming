package event_handling.event_listeners.mouse_event_example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MouseEventChallenge extends JFrame implements MouseListener {
    JButton b1, b2, b3, b4, b5, b6, check;

    public MouseEventChallenge() {
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        // JButton[] buttons = new JButton[6];
        // String[] buttonTexts = {"1", "2", "3", "4", "5", "6"};
        // for (int i = 0; i < buttons.; i++) {
        // buttons[i] = new JButton(buttonTexts[i]);
        // add(buttons[i]);
        // }
        check = new JButton("Check");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(check);
        check.addMouseListener(this);
        setSize(500, 500);
        setLayout(new GridLayout(3, 3, 10, 10));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new MouseEventChallenge();
    }

    public void reset() {
        b1.setBackground(null);
        b2.setBackground(null);
        b3.setBackground(null);
        b4.setBackground(null);
        b5.setBackground(null);
        b6.setBackground(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Random rand = new Random();
        int num = rand.nextInt(1, 7);
        System.out.println(num);
        String ButtonOne = b1.getText();
        String ButtonTwo = b2.getText();
        String ButtonThree = b3.getText();
        String ButtonFour = b4.getText();
        String ButtonFive = b5.getText();
        String ButtonSix = b6.getText();
        if (Integer.parseInt(ButtonOne) == num) {
            b1.setBackground(Color.green);
        }
        if (Integer.parseInt(ButtonTwo) == num) {
            b2.setBackground(Color.green);
        }
        if (Integer.parseInt(ButtonThree) == num) {
            b3.setBackground(Color.green);
        }
        if (Integer.parseInt(ButtonFour) == num) {
            b4.setBackground(Color.green);
        }
        if (Integer.parseInt(ButtonFive) == num) {
            b5.setBackground(Color.green);
        }
        if (Integer.parseInt(ButtonSix) == num) {
            b6.setBackground(Color.green);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Timer timer = new Timer(1000, event -> this.reset());
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
