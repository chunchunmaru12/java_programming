package src;

import javax.swing.*;
import java.awt.*;
import src.dao.SalesDAO;
import src.dao.ProductDAO;
import src.models.Sale;
import src.models.SaleItem;
import src.models.Product;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPanel extends JPanel {
    private JLabel totalLabel;
    private JComboBox<String> paymentMethodCombo;
    private JButton checkoutButton;
    private CartPanel cartPanel; // Reference to CartPanel
    private SalesDAO salesDAO = new SalesDAO();
    
    public CheckoutPanel(CartPanel cartPanel) {
        this.cartPanel = cartPanel;
        setLayout(new GridLayout(3, 2, 10, 10));
        setBorder(BorderFactory.createTitledBorder("Checkout"));
        
        add(new JLabel("Total Amount:"));
        totalLabel = new JLabel("$0.00");
        add(totalLabel);
        
        add(new JLabel("Payment Method:"));
        paymentMethodCombo = new JComboBox<>(new String[]{"Cash", "Credit Card", "Digital Wallet"});
        add(paymentMethodCombo);
        
        checkoutButton = new JButton("Checkout");
        add(checkoutButton);
        
        checkoutButton.addActionListener(e -> processCheckout());
    }
    
    public void updateTotal() {
        double total = cartPanel.getTotal();
        // Apply discount if total > $100
        if (total > 100) {
            total *= 0.90;
        }
        totalLabel.setText("$" + String.format("%.2f", total));
    }
    
    private void processCheckout() {
        updateTotal();
        double total = cartPanel.getTotal();
        if (total > 100) {
            total *= 0.90; // Apply discount
        }
        String paymentMethod = (String) paymentMethodCombo.getSelectedItem();
        // Create a sale record
        Sale sale = new Sale(total, paymentMethod);
        int saleId = salesDAO.insertSale(sale);
        
        if (saleId != -1) {
            List<SaleItem> saleItems = new ArrayList<>();
            ProductDAO productDAO = new ProductDAO();
            boolean stockUpdateSuccess = true;
            
            // Iterate over each cart item to update stock and create sale items
            for (src.models.CartItem item : cartPanel.getCartItems()) {
                // Retrieve current product details
                Product product = productDAO.getProductById(item.getProductId());
                if (product == null) {
                    JOptionPane.showMessageDialog(this, "Product not found: " + item.getProductName());
                    stockUpdateSuccess = false;
                    break;
                }
                
                // Calculate new stock and verify availability
                int newStock = product.getStockQuantity() - item.getQuantity();
                if (newStock < 0) {
                    JOptionPane.showMessageDialog(this, "Insufficient stock for product: " + product.getName());
                    stockUpdateSuccess = false;
                    break;
                }
                
                // If new stock is 0, remove the product; otherwise, update its stock.
                boolean updateResult;
                if (newStock == 0) {
                    updateResult = productDAO.deleteProduct(product.getId());
                    if (!updateResult) {
                        JOptionPane.showMessageDialog(this, "Failed to remove product: " + product.getName());
                        stockUpdateSuccess = false;
                        break;
                    }
                } else {
                    product.setStockQuantity(newStock);
                    updateResult = productDAO.updateProduct(product);
                    if (!updateResult) {
                        JOptionPane.showMessageDialog(this, "Failed to update stock for product: " + product.getName());
                        stockUpdateSuccess = false;
                        break;
                    }
                }
                
                // Create sale item record for this cart item
                SaleItem saleItem = new SaleItem(saleId, item.getProductId(), item.getQuantity(), item.getSubtotal());
                saleItems.add(saleItem);
            }
            
            // Abort checkout if any stock update failed
            if (!stockUpdateSuccess) {
                JOptionPane.showMessageDialog(this, "Checkout aborted due to stock issues.");
                return;
            }
            
            // Insert sale items into the database
            if (salesDAO.insertSaleItems(saleItems)) {
                JOptionPane.showMessageDialog(this, "Checkout successful!");
                // Optionally, generate and display receipt here.
                cartPanel.clearCart();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to record sale items.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Checkout failed.");
        }
    }
}
