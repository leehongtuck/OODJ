package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    String username, password;
    final static String FILENAME = "user.txt";

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User verify() {
        String row, txtUserId, txtUsername, txtPassword, txtPositionId, txtPosition;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] field = row.split("\\|\\|");
                txtUserId = field[0];
                txtUsername = field[1];
                txtPassword = field[2];
                txtPositionId = field[3];
                txtPosition = txtPositionId.substring(0, 1);

                if (username.equals(txtUsername) && password.equals(txtPassword)) {
                    if (txtPosition.equals("C")) {
                        System.out.println("this is a customer");
                        return new Customer(txtUserId, txtUsername, txtPositionId);
                    } else if (txtPosition.equals("M")) {
                        System.out.println("this is a manager");
                        return new Manager(txtUserId, txtUsername, txtPositionId);
                    } else if (txtPosition.equals("A")) {
                        System.out.println("this is an admin");
                        return new Admin(txtUserId, txtUsername, txtPositionId);
                    } else {
                        System.out.println("no position");
                    }
                } else {
                    System.out.println("wrong username or pw");
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
