/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import src.models.CartItem;
import src.dao.ProductDAO;
import src.models.Product;

public class CartPanel extends JPanel {
    private JTable cartTable;
    private DefaultTableModel cartTableModel;
    private List<CartItem> cartItems = new ArrayList<>();
    private JLabel totalLabel;
    private ProductDAO productDAO = new ProductDAO();
    
    public CartPanel() {
        setLayout(new BorderLayout());
        
        cartTableModel = new DefaultTableModel(new String[]{"Product ID", "Name", "Price", "Quantity", "Subtotal"}, 0);
        cartTable = new JTable(cartTableModel);
        add(new JScrollPane(cartTable), BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        totalLabel = new JLabel("Total: $0.00");
        bottomPanel.add(totalLabel, BorderLayout.WEST);
        JButton removeButton = new JButton("Remove Selected");
        bottomPanel.add(removeButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        
        removeButton.addActionListener(e -> removeSelectedItem());
    }
    
    public void addProductToCart(int productId, int quantity) {
        Product product = productDAO.getProductById(productId);
        if (product != null) {
            double subtotal = product.getPrice() * quantity;
            CartItem item = new CartItem(productId, product.getName(), product.getPrice(), quantity, subtotal);
            cartItems.add(item);
            updateCartTable();
        } else {
            JOptionPane.showMessageDialog(this, "Product not found");
        }
    }
    
    private void updateCartTable() {
        cartTableModel.setRowCount(0);
        double total = 0;
        for (CartItem item : cartItems) {
            cartTableModel.addRow(new Object[]{
                item.getProductId(),
                item.getProductName(),
                item.getPrice(),
                item.getQuantity(),
                item.getSubtotal()
            });
            total += item.getSubtotal();
        }
        totalLabel.setText("Total: $" + String.format("%.2f", total));
    }
    
    private void removeSelectedItem() {
        int selectedRow = cartTable.getSelectedRow();
        if (selectedRow >= 0) {
            cartItems.remove(selectedRow);
            updateCartTable();
        } else {
            JOptionPane.showMessageDialog(this, "Select an item to remove");
        }
    }
    
    public double getTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getSubtotal();
        }
        return total;
    }
    
    public List<CartItem> getCartItems() {
        return cartItems;
    }
    
    public void clearCart() {
        cartItems.clear();
        updateCartTable();
    }
}
