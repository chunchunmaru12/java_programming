/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.models;


public class SaleItem {
    private int saleId;
    private int productId;
    private int quantity;
    private double subtotal;
    
    public SaleItem() {}
    
    public SaleItem(int saleId, int productId, int quantity, double subtotal) {
        this.saleId = saleId;
        this.productId = productId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
    
    // Getters and setters
    public int getSaleId() { return saleId; }
    public void setSaleId(int saleId) { this.saleId = saleId; }
    
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}
