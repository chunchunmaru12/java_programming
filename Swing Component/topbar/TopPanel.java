package topbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frames.ProfileComponent;
public class TopPanel extends JPanel implements ActionListener{
    public TopPanel() {
        setLayout(new BorderLayout());
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Settings");
        JMenuItem menuItem1 = new JMenuItem("Logout");
        JMenuItem menuItem2 = new JMenuItem("Profile");
        menu.add(menuItem1,0);
        menuItem1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
        }});
        menuItem2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfileComponent().setVisible(true);
        }});
        menu.add(menuItem2,1);
        add(menuBar, BorderLayout.EAST);        
        menuBar.add(menu);
        setBackground(Color.BLACK);
        setFont(Font.getFont("Arial"));
        setForeground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
