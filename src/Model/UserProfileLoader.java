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

/**
 *
 * @author ht-19
 */
public class UserProfileLoader {
    private static final String USERFILENAME = "user.txt";
    private static final String MANAGERFILENAME = "manager.txt";
    private static final String CUSTOMERFILENAME = "customer.txt";
    
    public Customer loadCustomer(String customerId){
        String row;      
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            while((row = br.readLine())!= null){
                String[] str = row.split("\\|\\|");
                String txtUserId = str[0];
                String txtUsername = str[1];
                String txtCustomerId = str[3];
                
                if(customerId.equals(txtCustomerId)){
                    return new Customer(txtUserId, txtUsername, txtCustomerId);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Customer> loadCustomer(){
        ArrayList<Customer> customers = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            br.readLine();
            String row;
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");            
                String txtUserId = data[0];
                String txtUsername = data[1];
                String txtCustomerId = data[3];
                if(txtCustomerId.substring(0, 1).equals("C")){
                    customers.add(new Customer(txtUserId, txtUsername, txtCustomerId));
                }               
            }
            return customers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Manager loadManager(){
        
        return null;
    }
}
