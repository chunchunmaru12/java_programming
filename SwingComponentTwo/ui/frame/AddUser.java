package SwingComponentTwo.ui.frame;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddUser extends JInternalFrame implements ActionListener {
    private JLabel lbl_fullname, lbl_email, lbl_contact, lbl_add_image;
    private JTextField txt_fullname, txt_email, txt_contact;
    private JButton btn_add, btn_reset, select_img;

    public AddUser() {

        lbl_fullname = new JLabel("Full Name: ");
        lbl_contact = new JLabel("Enter Contact: ");
        lbl_email = new JLabel("Enter Email: ");
        lbl_add_image = new JLabel("No Image Selected: ");
        txt_email = new JTextField();
        txt_contact = new JTextField();
        txt_fullname = new JTextField();
        btn_add = new JButton("Add User");
        btn_reset = new JButton("Reset");
        select_img = new JButton("Select user profile");

        select_img.addActionListener(this);
        setSize(590, 500);
        setTitle("Add User");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout gl = new GridLayout(10, 1, 1, 1);
        setLayout(gl);
        add(lbl_fullname);
        add(txt_fullname);
        add(lbl_email);
        add(txt_email);
        add(lbl_contact);
        add(txt_contact);
        add(select_img);
        add(lbl_add_image);
        add(btn_add);
        add(btn_reset);
        setClosable(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.select_img) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selected_file = fileChooser.getSelectedFile();
                ImageIcon icon = new ImageIcon(selected_file.getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                this.lbl_add_image.setIcon(new ImageIcon(img));
                this.lbl_add_image.setText("");
            }
        }
    }

}
