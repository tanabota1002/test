package bean;

public class Staff {

    private int staffId;
    private String staffName;
    private String staffRole;
    private String password;
    private boolean authenticated; // ログイン状態を表すフィールドを追加

    // Getter and Setter for staffId
    public int getStaffID(){
        return staffId;
    }

    public void setStaffID(int staffId) {
        this.staffId = staffId;
    }

    // Getter and Setter for staffName
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    // Getter and Setter for staffRole
    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for authenticated (ログイン状態)
    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
