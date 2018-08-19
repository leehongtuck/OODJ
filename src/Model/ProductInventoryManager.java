package Model;

import java.io.*;

public class ProductInventoryManager {
    private static final String FILENAME = "product.txt";
    private static final String FILEHEADER = "ProductId||Name||Price||Type||Quantity";

    public void addProduct(Product p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write(p.getProductId() + "||" + p.getProductName() + "||" + p.getPrice()
                    + "||" + p + "||" + "0" + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editProduct(Product p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
             BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";

            while ((row = br.readLine()) != null) {
                String[] data = row.split("//|//|");
                String txtId = data[0];
                if (p.getProductId().equals(txtId)) {
                    fileData += p.getProductId() + "||" + p.getProductName() + "||" + p.getPrice()
                            + "||" + p + "||" + "0" + System.lineSeparator();
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

    public void deleteProduct(Product p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
             BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            while ((row = br.readLine()) != null) {
                String[] data = row.split("//|//|");
                String txtId = data[0];
                if (!(p.getProductId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            bw.write(FILEHEADER);
            bw.write(fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeInventory(Inventory i){

        if(i.changeQuantity(-1)){

        }
    }

}
