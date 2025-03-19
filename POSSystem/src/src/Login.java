package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.dao.UserDAO;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserDAO userDAO = new UserDAO();
    
    public Login() {
        setTitle("POS System Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);
        
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);
        
        JButton loginButton = new JButton("Login");
        panel.add(loginButton);
        
        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            if (userDAO.authenticate(username, password)) {
                JOptionPane.showMessageDialog(Login.this, "Login Successful!");
                new POSMainFrame().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(Login.this, "Invalid credentials.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        add(panel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}

