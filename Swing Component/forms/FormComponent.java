package forms;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
public class FormComponent extends JPanel {
    public FormComponent(){
        JLabel username = new JLabel("Enter Username: ");
        username.setForeground(Color.RED);
        username.setBounds(10,210,200,10);
        JTextField textField = new JTextField();
        textField.setBounds(10,270,500,10);

        JLabel password = new JLabel("Enter Password: ");
        password.setForeground(Color.RED);
        password.setBounds(10,330,200,50);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(10,390,500,50);
        setLayout(new GridLayout(4,1,0,0));
        add(username);
        add(textField);
        add(password);
        add(passwordField);

    }
}
