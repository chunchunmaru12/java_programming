package event_handling.event_listeners.mouse_event_example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MouseEvent extends JFrame implements MouseListener {
    JButton submit;
    JButton close;
    JLabel label_username;
    JLabel label_password;
    JTextField txt_username;
    JPasswordField txt_password;
    public MouseEvent() {
        close = new JButton("Close");
        submit = new JButton("Submit");

        txt_username = new JTextField();
        txt_password = new JPasswordField();

        label_username = new JLabel("Enter Username");
        label_password = new JLabel("Enter Password");
        add(label_username);
        add(txt_username);
        add(label_password);
        add(txt_password);
        this.reset();
        add(submit);
        add(close);
        submit.addMouseListener(this);
        setSize(400, 400);
        setLayout(new GridLayout(3, 2, 5, 5));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MouseEvent();
    }
    public void reset(){
        submit.setBackground(Color.black);
    }
    public void success(){
        submit.setBackground(Color.green);
    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.out.println("mouseClicked");
        String username = txt_username.getText();
        String password = new String(txt_password.getPassword());
        JOptionPane.showMessageDialog(rootPane, "Your name is " + username +"  password is " + password); 
        this.success(); 
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
        // submit.setBackground(Color.WHITE);
        // submit.setForeground(Color.RED);
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}
