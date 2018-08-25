package Model;

public class FragileProduct extends Product {
    private final double RATE = 0.15;

    public FragileProduct(String productId, String productName, double price) {
        super(productId, productName);
        this.price = price;
        this.charge = RATE;
    }
    
    public FragileProduct(String productName, double price) {
        super(productName);
        this.price = price;
        this.charge = RATE;
    }

    @Override
    public Double getCharge() {
        return charge;
    }

    @Override
    public Double getTotalPrice() {
        return price * charge;
    }

    @Override
    public String toString() {
        return "F";
    }
}
