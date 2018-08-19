package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductInventoryLoader {
    static final String FILENAME = "product.txt";
    public void load(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row, txtId, txtName, txtType;
            Product product;
            double txtPrice;
            int txtQty;

            ArrayList<Product> productArrayList = new ArrayList<>();
            ArrayList<Inventory> inventoryArrayList = new ArrayList<>();

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
                    productArrayList.add(product);

                } else if (txtType.equals("N")) {
                    product = new NonFragileProduct(txtId, txtName, txtPrice);
                    inventoryArrayList.add(new Inventory(product, txtQty));
                    productArrayList.add(product);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
