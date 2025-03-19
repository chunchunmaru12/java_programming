/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;
import javax.swing.*;

public class POSMainFrame extends JFrame {
    public POSMainFrame() {
        setTitle("Point of Sale System");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Create CartPanel and pass it to CheckoutPanel
        CartPanel cartPanel = new CartPanel();
        ProductManagementPanel productManagementPanel = new ProductManagementPanel(cartPanel);
        tabbedPane.addTab("Product Management", productManagementPanel);
        tabbedPane.addTab("Cart", cartPanel);
        // Create CheckoutPanel with reference to CartPanel
        CheckoutPanel checkoutPanel = new CheckoutPanel(cartPanel);
        tabbedPane.addTab("Checkout", checkoutPanel);
        
//        tabbedPane.addTab("Receipt", new ReceiptPanel());
        tabbedPane.addTab("Reports", new ReportPanel());
        
        add(tabbedPane);
    }
}
