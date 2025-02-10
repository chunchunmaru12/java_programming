package SwingComponentTwo.ui.frame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import SwingComponentTwo.ui.panel.MainPanel;
import SwingComponentTwo.ui.panel.TopPanel;
import SwingComponentTwo.ui.panel.BottomPanel;

public class MainFrame extends JFrame {
    MainPanel mp;
    BorderLayout bl;
    TopPanel panel;
    BottomPanel bp;
    

    public MainFrame() {
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Dashboard");
        
        panel = new TopPanel();
        bl = new BorderLayout();
        mp = new MainPanel();
        bp = new BottomPanel();
        
        panel.user_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                switchInternalFrame(new UserList());
            }
        });

        panel.user_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                switchInternalFrame(new AddUser());
            }
        });

        setLayout(bl);
        add(panel, BorderLayout.NORTH);
        add(bp, BorderLayout.SOUTH);
        add(mp, BorderLayout.CENTER);

        setVisible(true);
    }

    private void switchInternalFrame(JInternalFrame newFrame) {
        // Remove any existing internal frame before adding a new one
        for (Component comp : mp.getComponents()) {
            if (comp instanceof JInternalFrame) {
                mp.remove(comp);
            }
        }

        // Apply Look and Feel
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Add new frame and refresh UI
        mp.add(newFrame);
        newFrame.setVisible(true);
        mp.revalidate();
        mp.repaint();
    }
}
