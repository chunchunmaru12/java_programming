package MVCExample.view;

import MVCExample.controller.ProductController;

public class AddProductView {
    // public void printProductDetails(String productName, double productPrice, int
    // productQuantity, String productCategory){
    // System.out.println("Product Details:");
    // System.out.println("Name: " + productName);
    // System.out.println("Price: " + productPrice);
    // System.out.println("Quantity: " + productQuantity);
    // System.out.println("Category: " + productCategory);
    // }

    public ProductController addProduct() {
        String name = "ProductName";
        double price = 100.0;
        int quantity = 10;
        String category = "ProductCategory";
        ProductController pc = new ProductController();
        pc.setName(name);
        pc.setPrice(price);
        pc.setQuantity(quantity);
        pc.setCategory(category);

        return pc;
    }

}
