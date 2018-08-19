package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order {
    private String orderId;
    private Customer customer;
    private ArrayList<OrderItem> orderItems;
    private static String FILENAME = "order.txt";

    public Order(Customer customer, ArrayList<OrderItem> o) {
        this.orderId = Utility.generateId(FILENAME, "O");
        this.customer = customer;
        orderItems = o;
    }

    public Order(String orderId, Customer customer, ArrayList<OrderItem> o) {
        this.orderId = orderId;
        this.customer = customer;
        orderItems = o;
    }

    public void saveOrder() {

    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }
}
