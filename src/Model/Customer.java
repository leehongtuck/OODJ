package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Customer extends User {
    private String customerId, customerName, customerNric, customerAddress, customerPhone;
    private static final String FILENAME = "customer.txt";

    public Customer(String userId, String username, String customerId){
        super(userId, username);
        this.customerId = customerId;
        String row, fileCustId, fileCustName, fileNric, fileAddress, filePhone;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            while ((row = br.readLine()) != null) {
                String[] str = row.split("\\|\\|");
                fileCustId = str[0];
                fileCustName = str[1];
                fileNric = str[2];
                fileAddress = str[3];
                filePhone = str[4];
                
                if (fileCustId.equals(customerId)) {
                    customerName = fileCustName;
                    customerNric = fileNric;
                    customerAddress = fileAddress;
                    customerPhone = filePhone;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer(String userId, String username, String customerId, String customerName,
            String customerNric, String customerAddress, String customerPhone){
        super(userId, username);
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerNric = customerNric;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }
    
    public Customer(String username, String customerName,
                    String customerNric, String customerAddress, String customerPhone){
        super(username);
        this.customerId = Utility.generateId(FILENAME, "C");
        this.customerName = customerName;
        this.customerNric = customerNric;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerNric() {
        return customerNric;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }
    
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerNric(String customerNric) {
        this.customerNric = customerNric;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
    @Override
    public String toString(){
        return "Customer";
    }
}

