package event_handling.event_listeners.mouse_event_example;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class MouseMotionEvent extends JFrame implements MouseMotionListener {
    JLabel content;
    public MouseMotionEvent(){
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Mouse Motion Event");

        content = new JLabel("I am content");
        //content.setBounds(20,50,200,30);
        content.setHorizontalAlignment(SwingConstants.CENTER);
        add(content);
         
        content.addMouseMotionListener(this);

    }
    public static void main(String[] args) {
        new MouseMotionEvent();
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        content.setText("Mouse Dragged at X: "+e.getX()+" Y: "+e.getY());
    }
    @Override
    public void mouseMoved(MouseEvent e) {
       content.setText("Mouse Moved at X: "+e.getX()+" Y: "+e.getY());
    }
    
}
