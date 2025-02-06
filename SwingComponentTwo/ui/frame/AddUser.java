package SwingComponentTwo.ui.frame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddUser extends JInternalFrame {
    private JLabel lbl_fullname, lbl_email, lbl_contact;
    private JTextField txt_fullname, txt_email, txt_contact;
    private JButton btn_add, btn_reset, btn_close;

    public AddUser() {
        lbl_fullname = new JLabel("Full Name: ");
        lbl_contact = new JLabel("Enter Contact: ");
        lbl_email = new JLabel("Enter Email: ");
        txt_email = new JTextField();
        txt_contact = new JTextField();
        txt_fullname = new JTextField();
        btn_add = new JButton("Add User");
        btn_reset = new JButton("Reset");

        setSize(590, 500);
        setTitle("Add User");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout gl = new GridLayout(4, 2, 50, 50);
        setLayout(gl);
        add(lbl_fullname);
        add(txt_fullname);
        add(lbl_email);
        add(txt_email);
        add(lbl_contact);
        add(txt_contact);
        add(btn_add);
        add(btn_reset);
        setVisible(true);
    }

}
