package Model;

public class FragileProduct extends Product {
    final double RATE = 0.15;

    public FragileProduct(String productId, String productName, Double price) {
        super(productId, productName);
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