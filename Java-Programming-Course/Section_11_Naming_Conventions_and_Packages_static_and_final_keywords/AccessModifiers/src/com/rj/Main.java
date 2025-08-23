package com.rj;

public class Main {

    public static void main(String[] args) {
	    Account rjAccount = new Account("RJ");
        rjAccount.deposit(1000);
        rjAccount.withdraw(500);
        rjAccount.withdraw(-200);
        rjAccount.deposit(-20);
        rjAccount.calculateBalance();
        rjAccount.balance = 5000;

        System.out.println("Balance on account is " + rjAccount.getBalance());
        rjAccount.transactions.add(4500);
        rjAccount.calculateBalance();
    }
}
