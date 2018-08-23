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
    
    public void clearItems(){
        for(int i = cartItems.size()-1; i >=0 ; i--){
            cartItems.remove(i);
        }
    }

    public ArrayList<OrderItem> getCartItems() {
        return cartItems;
    }
}
