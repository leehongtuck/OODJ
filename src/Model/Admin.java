package Model;

public class Admin extends User {
    private String adminId;

    public Admin(String userId, String username, String adminId) {
        super(userId, username);
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Admin";
    }
}
