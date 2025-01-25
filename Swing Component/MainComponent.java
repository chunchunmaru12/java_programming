import javax.swing.*;
import java.awt.*;
import topbar.TopPanel;
import forms.FormComponent;
import bottom.BottomBar;
import frames.ProfileComponent;

public class MainComponent extends JFrame {
    BorderLayout bl;
    
    public MainComponent() {
        bl = new BorderLayout();
        setLayout(bl);
        TopPanel tp = new TopPanel();
        add(tp, bl.NORTH);
        FormComponent fc = new FormComponent();
        add(fc);
        BottomBar bb = new BottomBar();
        add(bb, bl.SOUTH);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    public static void main(String[] args) {
        new MainComponent();
    }
}
