package Model;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductInventoryManager {
    private static final String FILENAME = "product.txt";
    private static final String FILEHEADER = "ProductId||Name||Price||Type||Quantity" + System.lineSeparator();

    public void addProduct(Inventory i) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write(i.getProduct().getProductId() + "||" + i.getProduct().getProductName() + "||" 
                    + i.getProduct().getPrice() + "||" + i.getProduct().toString() + "||" + "0" + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editProduct(Inventory i) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
             BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";

            while ((row = br.readLine()) != null) {
                String[] data = row.split("//|//|");
                String txtId = data[0];
                if (i.getProduct().getProductId().equals(txtId)) {
                    fileData += i.getProduct().getProductId() + "||" + i.getProduct().getProductName() + "||" 
                            + i.getProduct().getPrice() + "||" + i.getProduct().toString() + "||" + i.getQuantity() + System.lineSeparator();
                } else {
                    fileData += row + System.lineSeparator();
                }
            }
            bw.write(FILEHEADER);
            bw.write(fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(Inventory i) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
             BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            while ((row = br.readLine()) != null) {
                String[] data = row.split("//|//|");
                String txtId = data[0];
                if (!(i.getProduct().getProductId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            bw.write(FILEHEADER);
            bw.write(fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editProduct(Product p, int quantity) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            String fileData = "";
            
            br.readLine();
            while ((row = br.readLine()) != null) {
                System.out.println(row);
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                int txtStock = Integer.parseInt(data[4]);
                if (p.getProductId().equals(txtId)) {
                    
                    fileData += p.getProductId() + "||" + p.getProductName() + "||" 
                            + p.getPrice() + "||" + p.toString() + "||" + Integer.toString(txtStock - quantity) 
                            + System.lineSeparator();
                } else {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))){
                bw.write(FILEHEADER);
                bw.write(fileData);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductInventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductInventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
