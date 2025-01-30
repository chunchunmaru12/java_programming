import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class ActionEventExample extends JFrame implements ActionListener{
    JButton click;
    public ActionEventExample(){
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // to put frame in center
        setLocationRelativeTo(null);
        click = new JButton();
        click.setText("Click on Me");
        click.setBounds(50,200,100,100);
        click.setBackground(Color.red);
        click.setBorder(new BevelBorder(HEIGHT));
        add(click);
        click.addActionListener(new ActionListener(){ 
        @Override
        public void actionPerformed(ActionEvent e) {
            click.setBackground(Color.green);
            click.setForeground(Color.white);
            click.setText("i am clicked");
        }});
        setVisible(true);
    }
    public static void main(String[] args) {
        new ActionEventExample();
        // SwingUtilities.invokeLater(new Runnable(){
        //     @Override
        //     public void run() {
        //         new ActionEventExample();
        //     }
        // });
        //// SwingUtilities.invokeLater(ActionEventExample::new);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}