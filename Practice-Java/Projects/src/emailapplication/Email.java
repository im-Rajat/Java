package emailapplication;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "rj.com";

    // default constructor to receive first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;     // this keyword refers to class level variable
        this.lastName = lastName;
        System.out.println("New User: " + this.firstName + " " + this.lastName);

        // calling setDepartment method to get department
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        // calling setRandomPassword method to get random password
        this.password = setRandomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password);

        // combining all stuff to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "."+ this.companySuffix;
//        System.out.println("Your Email is: " + this.email);
    }

    // function for setting Department
    private String setDepartment() {
        System.out.println("DEPARTMENT CODES:-\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None");
        System.out.print("Enter Department Code: ");
        Scanner scanner = new Scanner(System.in);

        int departmentChoice = scanner.nextInt();
        if (departmentChoice == 1) {
            return "sales";
        }
        else if (departmentChoice == 2) {
            return "dev";
        }
        else if (departmentChoice == 3) {
            return "acct";
        }
        else {
            return "";
        }
    }

    // fucntion for generating random password
    private String setRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz!@#$%^&*";
        char[] password = new char[length];     // can use StringBuilder also

        for (int i = 0; i < length; i++) {
            int randNum = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randNum);
        }

        return new String(password);
    }

    // function to set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;        // encapsulation (we are hiding the actual properties, data hiding and data binding)
    }

    // function to set alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // function for changing the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        String name = "DISPLAY NAME: " + firstName + " " + lastName;
        String emailid = "COMPANY EMAIL: " + email;
        String mailcapacity = "MAILBOX CAPACITY: " + mailboxCapacity + "mb";

        return name + "\n" + emailid + "\n" + mailcapacity;
    }

}
