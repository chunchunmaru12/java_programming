/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.models;



import java.util.Date;
import java.util.List;

public class Sale {
    private int id;
    private Date date;
    private double totalAmount;
    private String paymentMethod;
    private List<SaleItem> saleItems;
    
    public Sale() {}

    public Sale(double totalAmount, String paymentMethod) {
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.date = new Date();
    }
    
    public Sale(int id, Date date, double totalAmount, String paymentMethod) {
        this.id = id;
        this.date = date;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }
    
    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    
    public List<SaleItem> getSaleItems() { return saleItems; }
    public void setSaleItems(List<SaleItem> saleItems) { this.saleItems = saleItems; }
}
