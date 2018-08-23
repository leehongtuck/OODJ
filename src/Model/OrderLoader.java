/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ht-19
 */
public class OrderLoader {
    private static final String FILENAME = "order.txt";
    ArrayList<Order> orderArrayList = new ArrayList<>();
    
    public ArrayList<Order> load(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                System.out.println(row);
                String[] data = row.split("\\|\\|");
                String fileOrderId = data[0];
                String fileCustomerId = data[1];            
                String fileOrderItems = data[2];
                String orderItemsData[] = fileOrderItems.split(";");
                ArrayList<OrderItem> orderItems = new ArrayList<>();
                
                //load order items into order
                for(String s : orderItemsData){
                    s = s.substring(1, s.length() - 1);
                    String[] orderItemData = s.split(",");
                    
                    //load product into order item
                    Product product = new ProductInventoryLoader().load(orderItemData[0]);                    
                    orderItems.add(new OrderItem(product, Integer.parseInt(orderItemData[1])));
                    
                }
                Customer customer = new UserProfileLoader().loadCustomer(fileCustomerId);
                orderArrayList.add(new Order(fileOrderId, customer, orderItems));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("cannot read");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
    }
    
    public ArrayList<Order> load(Customer customer){
        System.out.println("im inside");
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                System.out.println(row);
               String[] data = row.split("\\|\\|");
                String fileOrderId = data[0];
                String fileCustomerId = data[1];
                String fileOrderItems = data[2];
                String orderItemsData[] = fileOrderItems.split(";");
               ArrayList<OrderItem> orderItems = new ArrayList<>();
                
                if(customer.getCustomerId().equals(fileCustomerId)){
                    //load order items into order
                    for(String s : orderItemsData){
                        s = s.substring(1, s.length() - 1);
                        String[] orderItemData = s.split(",");

                        //load product into order item
                        Product product = new ProductInventoryLoader().load(orderItemData[0]);                    
                        orderItems.add(new OrderItem(product, Integer.parseInt(orderItemData[1])));
                    }
                    orderArrayList.add(new Order(fileOrderId, customer, orderItems));
               }                                
           }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
    }
}
