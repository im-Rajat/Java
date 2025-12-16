package bankaccountapplication;

public class Savings extends Account {

    private int safetyDepositBixID;
    private int safetyDepositBoxKey;

    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBixID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        super.showInfo();
        System.out.println(
                "You Saving's Account Features: " +
                "\nSafety Deposit Box ID: " + safetyDepositBixID +
                "\nSafety Deposit Box Key: " + safetyDepositBoxKey
        );
    }
}
