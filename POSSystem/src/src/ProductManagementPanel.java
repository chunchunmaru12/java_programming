package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import src.dao.ProductDAO;
import src.models.Product;

public class ProductManagementPanel extends JPanel {
    private JTable productTable;
    private DefaultTableModel productTableModel;
    private JTextField nameField, categoryField, priceField, stockField;
    private ProductDAO productDAO = new ProductDAO();
    private CartPanel cartPanel;  // Reference to the CartPanel
    
    public ProductManagementPanel(CartPanel cartPanel) {
        this.cartPanel = cartPanel;  // store the reference
        setLayout(new BorderLayout());
        
        // Input panel for product details
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Product Details"));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        
        inputPanel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        inputPanel.add(categoryField);
        
        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);
        
        inputPanel.add(new JLabel("Stock Quantity:"));
        stockField = new JTextField();
        inputPanel.add(stockField);
        
        JButton addButton = new JButton("Add Product");
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);
        
        // Table for listing products
        productTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Category", "Price", "Stock"}, 0);
        productTable = new JTable(productTableModel);
        add(new JScrollPane(productTable), BorderLayout.CENTER);
        
        // Button panel for update, delete, add to cart, and refresh
        JPanel buttonPanel = new JPanel();
        JButton updateButton = new JButton("Update Product");
        JButton deleteButton = new JButton("Delete Product");
        JButton addToCartButton = new JButton("Add to Cart");
        JButton refreshButton = new JButton("Refresh");
        
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addToCartButton);
        buttonPanel.add(refreshButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
        loadProducts();
        
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String category = categoryField.getText().trim();
                double price = Double.parseDouble(priceField.getText().trim());
                int stock = Integer.parseInt(stockField.getText().trim());
                Product product = new Product(name, category, price, stock);
                if (productDAO.insertProduct(product)) {
                    JOptionPane.showMessageDialog(this, "Product added successfully.");
                    loadProducts();
                } else {
                    JOptionPane.showMessageDialog(this, "Error adding product.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid price or stock quantity.");
            }
        });
        
        updateButton.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Select a product to update.");
                return;
            }
            try {
                int id = (int) productTableModel.getValueAt(selectedRow, 0);
                String name = nameField.getText().trim();
                String category = categoryField.getText().trim();
                double price = Double.parseDouble(priceField.getText().trim());
                int stock = Integer.parseInt(stockField.getText().trim());
                Product product = new Product(id, name, category, price, stock);
                if (productDAO.updateProduct(product)) {
                    JOptionPane.showMessageDialog(this, "Product updated successfully.");
                    loadProducts();
                } else {
                    JOptionPane.showMessageDialog(this, "Error updating product.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid price or stock quantity.");
            }
        });
        
        addToCartButton.addActionListener(e -> addSelectedProductToCart());
        
        deleteButton.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Select a product to delete.");
                return;
            }
            int id = (int) productTableModel.getValueAt(selectedRow, 0);
            if (productDAO.deleteProduct(id)) {
                JOptionPane.showMessageDialog(this, "Product deleted successfully.");
                loadProducts();
            } else {
                JOptionPane.showMessageDialog(this, "Error deleting product.");
            }
        });
        
        // Refresh button simply reloads the products
        refreshButton.addActionListener(e -> loadProducts());
    }
    
    private void addSelectedProductToCart() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product first.");
            return;
        }

        // Retrieve the product ID from the table
        int productId = (int) productTableModel.getValueAt(selectedRow, 0);

        // Ask the user for the quantity
        String quantityStr = JOptionPane.showInputDialog(this, "Enter quantity:");
        if (quantityStr == null) {
            // User canceled
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity.");
            return;
        }

        // Send the product to the cart
        cartPanel.addProductToCart(productId, quantity);
        JOptionPane.showMessageDialog(this, "Product added to cart!");
    }
    
    private void loadProducts() {
        productTableModel.setRowCount(0);
        List<Product> products = productDAO.getAllProducts();
        for (Product p : products) {
            productTableModel.addRow(new Object[]{p.getId(), p.getName(), p.getCategory(), p.getPrice(), p.getStockQuantity()});
        }
    }
}
