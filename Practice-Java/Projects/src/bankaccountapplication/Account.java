package bankaccountapplication;

public abstract class Account implements IBaseRate {

    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();    // abstract methods must be implement in derive classes.

    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueIndex = index;
        int randomNumber = (int)(Math.random() *  Math.pow(10, 3));
        return lastTwoOfSSN + uniqueIndex + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued Interest: Rs." + accruedInterest);
        balance = balance + accruedInterest;
        printBalance();
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing Rs." + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing Rs." + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transferring Rs." + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your Balance is now : Rs." + balance);
    }

    public void showInfo() {
        System.out.println(
                "NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + rate + "%"
        );
    }
}
