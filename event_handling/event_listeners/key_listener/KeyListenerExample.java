package event_handling.event_listeners.key_listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class KeyListenerExample extends JFrame implements KeyListener {
    JLabel content;
    JTextField text;
    public KeyListenerExample(){
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Key Listener Example");

        content = new JLabel("I am content");
        content.setBounds(20,50,200,30);
    
        add(content);
         
        text = new JTextField();
        text.setBounds(20,100,200,30);
        text.setBackground(Color.red);
        text.setForeground(Color.WHITE);
        add(text);

        text.addKeyListener(this);
        content.addKeyListener(this);
        
    }
    public static void main(String[] args) {
        new KeyListenerExample();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed  "+e.getKeyChar());
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {

         
    }
}