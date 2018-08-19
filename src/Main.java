
import Model.FragileProduct;
import Model.Inventory;
import Model.Product;
import Model.ProductInventoryLoader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ht-19
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ProductInventoryLoader p = new ProductInventoryLoader();
        ArrayList<Inventory> inventoryArrayList = p.load();
        
        String[][] test = new String[inventoryArrayList.size()][];
        // TODO code application logic here
        
        for(int i = 0; i < inventoryArrayList.size(); i++){
            String productId = inventoryArrayList.get(i).getProduct().getProductId();
            String productName = inventoryArrayList.get(i).getProduct().getProductName();
            String price = Double.toString(inventoryArrayList.get(i).getProduct().getPrice());
            String type = "";
            if(inventoryArrayList.get(i).getProduct().toString().equals("F")){
                type = "Non-Fragile";
            }else if(inventoryArrayList.get(i).getProduct().toString().equals("F")){
                type = "Fragile";
            }
            String quantity = Integer.toString(inventoryArrayList.get(i).getQuantity());
            String[] data = {productId, productName, price, type, quantity};
            test[i] = data;
        }*/
        
        Product p1 = new FragileProduct("P001", "test", 30.0); 
        Product p2 = new FragileProduct("P001", "test", 30.0); 
        if(p1.equals(p2)){
            System.out.println("yes equal");
        }else{
            System.out.println("no not");
        }
        
    }
    
}
