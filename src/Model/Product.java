package Model;

public abstract class Product {
    protected String productId;
    protected String productName;
    protected double price, charge;
    protected static final String FILENAME = "product.txt";

    public Product(String productId, String productName){
        this.productId = productId;
        this.productName = productName;
    }
    
    public Product(String productName){
        this.productId = Utility.generateId(FILENAME, "P");
        this.productName = productName;
    }
  
    public Double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    abstract Double getCharge();

    abstract Double getTotalPrice();
}
