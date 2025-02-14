package main;

import javax.swing.SwingUtilities;
import view.EmployeeView;
public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeView frame = new EmployeeView();
            frame.setVisible(true);
        });
    }
}