package src;

import javax.swing.*;
import java.awt.*;

public class ReceiptPanel extends JInternalFrame {
    
    private JLabel nameValue, categoryValue, priceValue, quantityValue, subTotalValue;
    private JButton printButton;
    
   
    public ReceiptPanel(){}
    public ReceiptPanel(String productName, String category, double price, int quantity, double subTotal) {
        // JInternalFrame(title, resizable, closable, maximizable, iconifiable)
        super("Receipt", true, true, true, true);
        setSize(450, 300);
        setLayout(new BorderLayout(10, 10));
        
        // Top panel with title and address
        JPanel topPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        JLabel titleLabel = new JLabel("Point Of Sale System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        JLabel addressLabel = new JLabel("Dhobighat, Lalitpur", SwingConstants.CENTER);
        
        topPanel.add(titleLabel);
        topPanel.add(addressLabel);
        
        // Separator and "Product Detail" label
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        
         
        // "Product Detail" label
        JLabel productDetailLabel = new JLabel("Product Detail");
        productDetailLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        productDetailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
         
        middlePanel.add(Box.createVerticalStrut(10));
        middlePanel.add(productDetailLabel);
        middlePanel.add(Box.createVerticalStrut(10));
        
        // Fields panel for Name, Category, Price, Quantity, SubTotal
        JPanel fieldsPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        fieldsPanel.add(new JLabel("Name:"));
        nameValue = new JLabel(productName);
        fieldsPanel.add(nameValue);
        
        fieldsPanel.add(new JLabel("Category:"));
        categoryValue = new JLabel(category);
        fieldsPanel.add(categoryValue);
        
        fieldsPanel.add(new JLabel("Price:"));
        priceValue = new JLabel(String.valueOf(price));
        fieldsPanel.add(priceValue);
        
        fieldsPanel.add(new JLabel("Quantity:"));
        quantityValue = new JLabel(String.valueOf(quantity));
        fieldsPanel.add(quantityValue);
        
        fieldsPanel.add(new JLabel("SubTotal:"));
        subTotalValue = new JLabel(String.format("%.2f", subTotal));
        fieldsPanel.add(subTotalValue);
        
        middlePanel.add(fieldsPanel);
        
        // Bottom panel with a "Print" button
        JPanel bottomPanel = new JPanel();
        printButton = new JButton("Print");
        bottomPanel.add(printButton);
        
        // Add everything to the internal frame
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        // Make the internal frame visible
        setVisible(true);
    }
    
    // Optionally, provide a getter for the print button if you need to handle printing logic
    public JButton getPrintButton() {
        return printButton;
    }
}
