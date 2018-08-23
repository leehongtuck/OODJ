
import Model.FragileProduct;
import Model.Inventory;
import Model.OrderItem;
import Model.Product;
import Model.ProductInventoryLoader;
import Model.UserProfileLoader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ht-19
 */
public class Main {
    private static final String FILENAME = "order.txt";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
    /*    try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            System.out.println(br.readLine());
            String row;
            while((row = br.readLine())!= null){
                System.out.println(row);
                String data[] = row.split("\\|\\|");
                 String fileOrderId = data[0];
                String fileCustomerId = data[1];            
                String fileOrderItems = data[2];
                String orderItemsData[] = fileOrderItems.split(",");
                ArrayList<OrderItem> orderItems = new ArrayList<>();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    */
    new UserProfileLoader().loadCustomer();    
    }
    
}
