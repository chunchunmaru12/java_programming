package Graphics2DExample;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class MainPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //drawing rectangle
        //g2d.drawRect(10, 10, 100, 100);
        GradientPaint gp = new GradientPaint(50, 150, Color.magenta, 150, 250, Color.cyan);
        g2d.setPaint(gp);
        g2d.fillOval(50, 150, 250, 150);
        GradientPaint gp1 = new GradientPaint(10, 10, Color.magenta, 100, 110, Color.cyan);
        g2d.setPaint(gp1);
       // g2d.setPaint(new GradientPaint(10, 10, Color.red, 110, 110, Color.blue));
        g2d.fillRect(10, 10, 100, 100);
        
        
        g2d.setColor(Color.blue);
        
        g2d.drawLine(50, 380, 400, 50);
        g2d.setColor(Color.black);
        g2d.drawString("Hello World", 200, 200);
    }
   
}
