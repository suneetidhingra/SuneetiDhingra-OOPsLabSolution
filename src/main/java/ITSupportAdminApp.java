import java.util.Scanner;

public class ITSupportAdminApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fName, lName;
        System.out.print("Enter First Name: ");
        fName = sc.next();
        System.out.print("Enter Last Name: ");
        lName = sc.next();

        int choice;
        String department;
        String[] departments = {"undefined", "tech", "admin", "hr", "legal"};
        while (true) {
            System.out.println("");
            System.out.println("1. Technical");
            System.out.println("2. Admin");
            System.out.println("3. Human Resource");
            System.out.println("4. Legal");
            System.out.print("Please select the department from the above: ");
            choice = sc.nextInt();
            if (choice < 0 || choice > 4) {
                System.out.println("\nInvalid department!");
                continue;
            }
            department = departments[choice];
            break;
        }
        Employee employee = new Employee(fName, lName);
        employee.setDepartment(department);

        System.out.println("");
        CredentialService credentialService = new CredentialService();
        credentialService.showCredentials(employee);
    }
}
