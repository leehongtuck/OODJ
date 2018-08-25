package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends User {
    private String managerId, managerName, managerEmployeeId;
    private static final String FILENAME = "manager.txt";
    
    public Manager(String userId, String username, String managerId) {
        super(userId, username);
        this.managerId = managerId;
        String row, fileManagerId, fileManagerName, fileManagerEmpId;
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            br.readLine();
            while((row = br.readLine())!= null){
                String data[] = row.split("\\|\\|");
                fileManagerId = data[0];
                fileManagerName = data[1];
                fileManagerEmpId = data[2];
                
                if(fileManagerId.equals(managerId)){
                    this.managerName = fileManagerName;
                    this.managerEmployeeId = fileManagerEmpId;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Manager(String userId, String username, String managerName, String managerEmployeeId){
        super(username);
        this.managerId = Utility.generateId(FILENAME, "M");
        this.managerName = managerName;
        this.managerEmployeeId = managerEmployeeId;
    }

    public String getManagerId() {
        return managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerEmployeeId() {
        return managerEmployeeId;
    }
    
    public void setManagerName(String managerName){
        this.managerName = managerName;
    }
    
    public void setManagerEmployeeId(String managerEmployeeId){
        this.managerEmployeeId = managerEmployeeId;
    }
}
