import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;

public class CredentialService {


    public static String generatePassword() {

        // Reference: https://www.codegrepper.com/code-examples/java/random+password+generator+java
        Random rand = new SecureRandom();

        String symbolsStr = "^$*.[]{}()?-\"!@#%&/\\,><':;|_~`";
        String lowerCaseStr = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbersStr = "0123456789";
        char[] symbols = symbolsStr.toCharArray();
        char[] lowerCase = lowerCaseStr.toCharArray();
        char[] upperCase = upperCaseStr.toCharArray();
        char[] numbers = numbersStr.toCharArray();
        char[] allChars = (symbolsStr + lowerCaseStr + upperCaseStr + numbersStr).toCharArray();

        int length = 14;
        char[] password = new char[length];

        // get the requirements out of the way
        password[0] = lowerCase[rand.nextInt(lowerCase.length)];
        password[1] = upperCase[rand.nextInt(upperCase.length)];
        password[2] = numbers[rand.nextInt(numbers.length)];
        password[3] = symbols[rand.nextInt(symbols.length)];

        // populate rest of the password with random chars
        for (int i = 4; i < length; i++) {
            password[i] = allChars[rand.nextInt(allChars.length)];
        }

        // shuffle the 1st 4 characters with the rest
        for (int i = 0; i < 4; i++) {
            int randomPosition = rand.nextInt(password.length);
            char temp = password[i];
            password[i] = password[randomPosition];
            password[randomPosition] = temp;
        }
        return new String(password);
    }

    public String generateEmailAddress(Employee employee) {

        return employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() + "@" + employee.getDepartment() + ".greatlearning.com";
    }

    public void showCredentials(Employee employee) {

        String fName = employee.getFirstName();
        String email = employee.getEmailAddress();
        if (Objects.isNull(email) || email.length() == 0) {
            email = generateEmailAddress(employee);
            employee.setEmailAddress(email);
        }
        String password = employee.getPassword();
        if (Objects.isNull(password) || password.length() == 0) {
            password = generatePassword();
            employee.setPassword(password);
        }

        System.out.println("Dear " + fName + " your generated credentials are as follows");
        System.out.println("Email    ---> " + email);
        System.out.println("Password ---> " + password);
    }
}
