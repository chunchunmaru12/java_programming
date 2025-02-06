package SwingComponentTwo.ui.frame;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import SwingComponentTwo.ui.panel.MainPanel;
import SwingComponentTwo.ui.panel.TopPanel;
import SwingComponentTwo.ui.frame.AddUser;
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
        panel.user_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try{
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                }catch(UnsupportedLookAndFeelException ex){
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                AddUser au = new AddUser();
                mp.add(au);
            }
        });
        setVisible(true);
        setLayout(bl);
        add(panel, bl.NORTH);
        add(bp, bl.SOUTH);
        add(mp, bl.CENTER);
    }
}
