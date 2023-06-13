import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String job;
    private int age;
    private String accountType;
    private String companyName;
    private ArrayList<IAddress> addressList = new ArrayList<>();
    private LocalDate lastLogin;

    public User(String name, String lastName, String email, String password, String job, int age, String accountType, String companyName) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.accountType = accountType;
        if (companyName == null) {
            this.companyName = "";
        } else {
            this.companyName = companyName;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<IAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<IAddress> addressList) {
        this.addressList = addressList;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
