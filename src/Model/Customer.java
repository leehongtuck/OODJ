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
    
    public Customer(String customerId){
        this.customerId = customerId;
             String row, txtId, txtName, txtNric, txtAddress, txtPhone;
        try (BufferedReader brCust = new BufferedReader(new FileReader(FILENAME));
                BufferedReader brUser = new BufferedReader(new FileReader("user.txt"))) {
            
            
            while((row = brUser.readLine())!= null){
                String[] str = row.split("\\|\\|");
                String txtUserId = str[0];
                String txtUsername = str[1];
                String txtCustomerId = str[3];
                
                if(customerId.equals(txtCustomerId)){
                    this.userId = txtUserId;
                    this.username = txtUsername;
                }
            }
            
            while ((row = brCust.readLine()) != null) {
                String[] str = row.split("\\|\\|");
                txtId = str[0];
                txtName = str[1];
                txtNric = str[2];
                txtAddress = str[3];
                txtPhone = str[4];

                if (txtId.equals(customerId)) {
                    customerName = txtName;
                    customerNric = txtNric;
                    customerAddress = txtAddress;
                    customerPhone = txtPhone;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    
    @Override
    public String toString(){
        return "Customer";
    }
}

