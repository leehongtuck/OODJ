package Model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<OrderItem> cartItems = new ArrayList<>();

    public void add(OrderItem o){
        cartItems.add(o);
    }

    public void remove(OrderItem o){
        cartItems.remove(o);
    }

    public ArrayList<OrderItem> getCartItems() {
        return cartItems;
    }
}
