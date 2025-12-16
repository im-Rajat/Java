package bankaccountapplication;

import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

public class BankAccountApp {

    public static void main(String[] args) throws IOException {

        List<Account> accounts = new LinkedList<>();

        String file = "C:\\Users\\rajatkumar\\Documents\\IdeaProjects\\Practice-Java-by-Building-Projects\\NewBankAccounts.csv";
        List<String[]> newAccountHolder = utilities.CSV.read(file);

        for (String[] accountHolder : newAccountHolder) {
//            System.out.println("NEW ACCOUNT: ");
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
//            System.out.println(name + " " + sSN + " " + accountType + " Rs." + initDeposit);

            if(accountType.equals("Savings")) {
//                System.out.println("OPEN A SAVINGS ACCOUNT");
                accounts.add(new Savings(name, sSN, initDeposit));
            }
            else if (accountType.equals("Checking")) {
//                System.out.println("OPEN A CHECKINGS ACCOUNT");
                accounts.add(new Checking(name, sSN, initDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }

        }

        /*for (Account acc : accounts) {
            acc.showInfo();
            System.out.println("*******************************************");
        }*/

        accounts.get(2).showInfo();


        /*Checking ca1 = new Checking("RJ", "123456789", 1500);
        ca1.showInfo();

        System.out.println("***************************************");

        Savings sa1 = new Savings("KK", "123456780", 1000);
        sa1.showInfo();
        sa1.compound();
        sa1.deposit(5000);
        sa1.withdraw(2000);
        sa1.transfer("Rent", 1000);*/

    }
}
