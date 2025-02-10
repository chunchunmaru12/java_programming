package SwingComponentTwo.ui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
    JMenuBar jmb;
    JMenu user, setting;
    public JMenuItem user_list, user_add, profile, logout;

    public TopPanel() {
        jmb = new JMenuBar();
        user = new JMenu("Users", true);
        setting = new JMenu("Settings", true);
        user_list = new JMenuItem("Show Users");
        user_add = new JMenuItem("Add User");
        // ImageIcon addIcon = new ImageIcon(TopPanel.class.getResource("/SwingComponentTwo/icons/user.png"));
        // ImageIcon showIcon = new ImageIcon(TopPanel.class.getResource("/SwingComponentTwo/icons/profile-user.png"));
        // ImageIcon profileIcon = new ImageIcon(TopPanel.class.getResource("/SwingComponentTwo/icons/logout.png"));
        // ImageIcon settingIcon = new ImageIcon(TopPanel.class.getResource("/SwingComponentTwo/icons/settings.png"));
        // Image resize_add= addIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        // Image resize_show= showIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        // Image resize_profile= profileIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        // Image resize_settings = settingIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
         
         
        profile = new JMenuItem("Profile");
        logout = new JMenuItem("Logout");
        user_add.setIcon(new ImageIcon(loadImage("/SwingComponentTwo/icons/user.png", 20, 20)));
        user.setIcon(new ImageIcon(loadImage("/SwingComponentTwo/icons/profile-user.png", 20, 20)));
        logout.setIcon(new ImageIcon(loadImage("/SwingComponentTwo/icons/logout.png", 20, 20)));
        setting.setIcon(new ImageIcon(loadImage("/SwingComponentTwo/icons/settings.png", 20, 20)));
        user.add(user_list, 0);
        user.add(user_add, 1);
        
        setting.add(profile, 0);
        setting.add(logout, 1);
        jmb.add(user);
        jmb.add(setting);
        add(jmb, BorderLayout.NORTH);
        setVisible(true);

    }
    public Image loadImage(String url,int width ,int height) {
        Image img=null;
        try {
            ImageIcon icon = new ImageIcon(TopPanel.class.getResource(url));
            img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Image not found");
        }
        return img;
    }
}
