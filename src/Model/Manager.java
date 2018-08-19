package Model;

public class Manager extends User {
    private String managerId, managerName, managerEmployeeId;
    public Manager(String userId, String username, String managerId) {
        super(userId, username);
        this.managerId = managerId;
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
}
