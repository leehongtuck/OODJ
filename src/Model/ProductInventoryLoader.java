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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventoryArrayList;
    }
    
    public ArrayList<Inventory> load(String search){
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
                txtType = str[3];
                if(!(txtId.matches(search+".*")||txtName.matches(search +".*")
                        ||txtType.matches(search+".*"))){
                    continue;
                }
                txtPrice = Double.parseDouble(str[2]);             
                txtQty = Integer.parseInt(str[4]);

                if (txtType.equals("F")) {
                    product = new FragileProduct(txtId, txtName, txtPrice);
                    inventoryArrayList.add(new Inventory(product, txtQty));

                } else if (txtType.equals("N")) {
                    product = new NonFragileProduct(txtId, txtName, txtPrice);
                    inventoryArrayList.add(new Inventory(product, txtQty));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventoryArrayList;
    }
    
    public Product createProduct(String productId){
         try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row, txtId, txtName, txtType;
            Product product;
            double txtPrice;
            br.readLine();
            while ((row = br.readLine()) != null) {
                String str[] = row.split("\\|\\|");
                txtId = str[0];
                
                if(!txtId.equals(productId)){
                    continue;
                }
                txtName = str[1];
                txtPrice = Double.parseDouble(str[2]);
                txtType = str[3];

                if (txtType.equals("F")) {
                    product = new FragileProduct(txtId, txtName, txtPrice);

                } else if (txtType.equals("N")) {
                    product = new NonFragileProduct(txtId, txtName, txtPrice);
                }else{
                    product = null;
                }
                return product;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;  
    }
}
