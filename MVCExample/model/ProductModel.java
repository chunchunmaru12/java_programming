package MVCExample.model;

public class ProductModel {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public ProductModel(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public ProductModel() {
        this.name = "";
        this.price = 0;
        this.quantity = 0;
        this.category = "";
    }

    public String getName() {
        return name;
    }
    public String getCategory(){
        return category;
    }
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
