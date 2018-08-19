package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductInventoryLoader {
    static final String FILENAME = "product.txt";
    public ArrayList<Inventory> load(){
        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row, txtId, txtName, txtType;
            Product product;
            double txtPrice;
            int txtQty;
            br.readLine();
            while ((row = br.readLine()) != null) {
                String str[] = row.split("\\|\\|");
                txtId = str[0];
                txtName = str[1];
                txtPrice = Double.parseDouble(str[2]);
                txtType = str[3];
                txtQty = Integer.parseInt(str[4]);

                if (txtType.equals("F")) {
                    product = new FragileProduct(txtId, txtName, txtPrice);
                    inventoryArrayList.add(new Inventory(product, txtQty));

                } else if (txtType.equals("N")) {
                    product = new NonFragileProduct(txtId, txtName, txtPrice);
                    inventoryArrayList.add(new Inventory(product, txtQty));
                }
            }
            
            for(int i = 0; i < inventoryArrayList.size(); i++){
                String productId = inventoryArrayList.get(i).getProduct().getProductId();
                String productName = inventoryArrayList.get(i).getProduct().getProductName();
                Double price = inventoryArrayList.get(i).getProduct().getPrice();
                String type;
                if(inventoryArrayList.get(i).getProduct().toString().equals("F")){
                    type = "Non-Fragile";
                }else if(inventoryArrayList.get(i).getProduct().toString().equals("F")){
                    type = "Fragile";
                }
                int quantity = inventoryArrayList.get(i).getQuantity();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventoryArrayList;
    }
}
