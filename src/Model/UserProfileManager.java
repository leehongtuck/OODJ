package Model;

import java.io.*;

public class UserProfileManager {
    private static final String USERFILENAME = "user.txt";
    private static final String MANAGERFILENAME = "manager.txt";
    private static final String CUSTOMERFILENAME = "customer.txt";
    private static final String USERFILEHEADER = "UserID||Username||Password||PositionID";
    private static final String CUSTOMERFILEHEADER = "CustomerId||CustomerName||CustomerNRIC||CustomerAddress||CustomerPhone"
            + System.lineSeparator();
    private static final String MANAGERFILEHEADER = "ManagerId||ManagerName||ManagerEmployeeId";
    
    private boolean checkDuplicate(Customer c) {
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERFILENAME))) {
            String row;
            while ((row = br.readLine())!= null){

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addUser(Customer c, char[] password) {
        try (BufferedWriter bwUser = new BufferedWriter(new FileWriter(USERFILENAME, true));
             BufferedWriter bwCustomer = new BufferedWriter(new FileWriter(CUSTOMERFILENAME, true))) {
            bwUser.write(c.getUserId() + "||" + c.getUsername() + "||" +
                    new String(password) + "||" + c.getCustomerId() + System.lineSeparator());
            System.out.println("write in user file");
            bwCustomer.write(c.getCustomerId() + "||" + c.getCustomerName() + "||" + c.getCustomerNric() + "||"
                    + c.getCustomerAddress() + "||" + c.getCustomerPhone() + System.lineSeparator());
            System.out.println("write in customer file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(Manager m, char[] password) {
        try (BufferedWriter bwUser = new BufferedWriter(new FileWriter(USERFILENAME, true));
             BufferedWriter bwManager = new BufferedWriter(new FileWriter(MANAGERFILENAME, true))) {
            bwUser.write(m.getUserId() + "||" + m.getUsername() + "||" +
                    new String(password) + "||" + m.getManagerId());
            bwManager.write(m.getUserId() + "||" + m.getManagerName() + "||" + m.getManagerEmployeeId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editUser(Customer c) {
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                if (c.getCustomerId().equals(txtId)) {
                    fileData += c.getCustomerName() + "||" + c.getCustomerNric() + "||" +
                            c.getCustomerAddress() + "||" + c.getCustomerPhone() + System.lineSeparator();
                } else {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(CUSTOMERFILENAME))){
                bw.write(CUSTOMERFILEHEADER);
                bw.write(fileData);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editUser(Manager m) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(MANAGERFILENAME));
             BufferedReader br = new BufferedReader(new FileReader(MANAGERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("//|//|");
                String txtId = data[0];
                if (m.getManagerId().equals(txtId)) {
                    fileData += m.getManagerId() + "||" + m.getManagerName() + "||" + m.getManagerEmployeeId() + "||"
                            + System.lineSeparator();
                } else {
                    fileData += row + System.lineSeparator();
                }
            }
            bw.write(CUSTOMERFILEHEADER);
            bw.write(fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Customer c) {
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                if (!(c.getCustomerId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(CUSTOMERFILENAME))){
                bw.write(CUSTOMERFILEHEADER);
                bw.write(fileData);
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[3];
                if (!(c.getCustomerId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(USERFILENAME))){
                bw.write(USERFILEHEADER);
                bw.write(fileData);
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Manager m) {
        try (BufferedReader br = new BufferedReader(new FileReader(MANAGERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("//|//|");
                String txtId = data[0];
                if (!(m.getManagerId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(MANAGERFILENAME))){
                bw.write(MANAGERFILEHEADER);
                bw.write(fileData);
            }     
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[3];
                if (!(m.getManagerId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(USERFILENAME))){
                bw.write(USERFILEHEADER);
                bw.write(fileData);
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
