package MVCExample.controller;

import MVCExample.model.ProductModel;

public class ProductController {
    private final ProductModel pm;
    

    public void setName(String Name) {
        pm.setName(Name);
    }

    public String getName() {
        return pm.getName();
    }

    public void setPrice(double price) {
        pm.setPrice(price);
    }

    public double getPrice() {
        return pm.getPrice();
    }

    public void setQuantity(int quantity) {
        pm.setQuantity(quantity);
    }

    public int getQuantity() {
        return pm.getQuantity();
    }

    public void setCategory(String category) {
        pm.setCategory(category);
    }

    public String getCategory() {
        return pm.getCategory();
    }

    public ProductController storeProduct(ProductController pc) {
        return pc;
    }

    public ProductController() {
        pm = new ProductModel();
    }

    // public ProductController(String name, double price, int quantity, String category) {
    //     pm = new ProductModel(name, price, quantity, category);
    // }

    public void displayProduct() {
        System.out.println("Product Details:");
        System.out.println("Name: " + pm.getName());
        System.out.println("Price: " + pm.getPrice());
        System.out.println("Quantity: " + pm.getQuantity());
        System.out.println("Category: " + pm.getCategory());
        
    }

}
