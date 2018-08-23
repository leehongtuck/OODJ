package Model;

public class Inventory {
    private Product product;
    private int quantity;

    public Inventory(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void changeQuantity(int quantity) {
        if ((this.quantity + quantity)>= 0 ) {
            this.quantity += quantity;
        }
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
