package Model;

import java.io.*;
import java.util.ArrayList;

public class OrderManager {
    private static final String FILENAME = "order.txt";
    private static final String FILEHEADER = "OrderId||CustomerId||OrderItems"
            + System.lineSeparator();

    public void addOrder(Order order) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            String items = "";
            for (int i = 0; i < order.getOrderItems().size(); i++) {
                //add a comma if the records are not ending, no comma if is the last one
                if (i != order.getOrderItems().size() - 1) {
                    items += "(" + order.getOrderItems().get(i).getProduct().getProductId() + ","
                            + order.getOrderItems().get(i).getQuantity() + "),";
                } else {
                    items += "(" + order.getOrderItems().get(i).getProduct().getProductId() + ","
                            + order.getOrderItems().get(i).getQuantity() + ")";
                }
            }
            String toWrite = order.getOrderId() + "||" + order.getCustomer().getCustomerId() +
                    "||" + items + System.lineSeparator();
            bw.write(toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editOrder(Order order) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
             BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine())!= null){
                String data[] = row.split("//|//|");
                String txtId = data[0];
                if(order.getOrderId().equals(txtId)){
                    fileData += order.getOrderId() + "||" + order.getCustomer().getCustomerId() +
                            "||" + this.formatOrderItems(order) + System.lineSeparator();
                }else {
                    fileData += row + System.lineSeparator();
                }
            }
            bw.write(FILEHEADER);
            bw.write(fileData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(Order order) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
             BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine())!= null){
                String data[] = row.split("//|//|");
                String txtId = data[0];
                if(!(order.getOrderId().equals(txtId))){
                    fileData += row + System.lineSeparator();
                }
            }
            bw.write(FILEHEADER);
            bw.write(fileData);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String formatOrderItems(Order order){
        String items = "";
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            //add a comma if the records are not ending, no comma if is the last one
            if (i != order.getOrderItems().size() - 1) {
                items += "(" + order.getOrderItems().get(i).getProduct().getProductId() + ","
                        + order.getOrderItems().get(i).getQuantity() + "),";
            } else {
                items += "(" + order.getOrderItems().get(i).getProduct().getProductId() + ","
                        + order.getOrderItems().get(i).getQuantity() + ")";
            }
        }
        return items;
    }
}
