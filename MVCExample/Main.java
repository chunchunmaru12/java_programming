package MVCExample;

import MVCExample.controller.ProductController;
import MVCExample.view.AddProductView;

public class Main {
    public static void main(String[] args) {
        AddProductView apv = new AddProductView();
        ProductController pc = apv.addProduct();
        // apv.printProductDetails(pc.getName(), pc.getPrice(), pc.getQuantity(), pc.getCategory());
        pc.displayProduct();
        
    }
}
