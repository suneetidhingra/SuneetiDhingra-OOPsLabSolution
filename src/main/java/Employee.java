public class Employee {

    private final String firstName;
    private final String lastName;
    private String department;
    private String emailAddress;
    private String password;

    Employee(final String fName, String lName) {

        firstName = fName;
        lastName = lName;
    }

    public void setDepartment(final String department) {

        this.department = department;
    }

    public void setEmailAddress(final String emailAddress) {

        this.emailAddress = emailAddress;
    }

    public void setPassword(final String password) {

        this.password = password;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getDepartment() {

        return department;
    }

    public String getEmailAddress() {

        return emailAddress;
    }

    public String getPassword() {

        return password;
    }
}
