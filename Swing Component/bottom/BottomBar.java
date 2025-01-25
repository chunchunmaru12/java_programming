package bottom;
import java.awt.FlowLayout;

import javax.swing.*;
public class BottomBar extends JPanel{
    public BottomBar(){
        JLabel copyRight= new JLabel("Copyright ©2025");
        JLabel org = new JLabel("DAV College");
        JLabel dev = new JLabel("Sixth Semester 2025");
        setLayout(new FlowLayout(1,2,2));
        setBackground(java.awt.Color.black);
        copyRight.setForeground(java.awt.Color.white);
        org.setForeground(java.awt.Color.white);
        dev.setForeground(java.awt.Color.white);
        add(copyRight);
        add(org);
        add(dev);
    }
}
