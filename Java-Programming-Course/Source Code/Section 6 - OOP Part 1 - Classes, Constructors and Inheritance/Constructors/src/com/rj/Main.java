package com.rj;

public class Main {

    public static void main(String[] args) {

        Account firstAccount = new Account();
//        Account firstAccount = new Account("12345", 0.00, "First", "first@email.com", "989898");

        System.out.println(firstAccount.getNumber());
        System.out.println(firstAccount.getBalance());
//        firstAccount.setNumber("12345");
//        firstAccount.setBalance(0.00);
//        firstAccount.setCustomerName("First");
//        firstAccount.setCustomerEmailAddress("first@email.com");
//        firstAccount.setCustomerPhoneNumber("989898");

        firstAccount.withdrawal(100.0);
        firstAccount.deposit(50.0);
        firstAccount.withdrawal(100.0);
        firstAccount.deposit(51.0);
        firstAccount.withdrawal(100.0);

        Account secondAccount = new Account("second", "seconds@email.com", "12345");
        System.out.println(secondAccount.getNumber() + " name " + secondAccount.getCustomerName());

        System.out.println();

        VipPerson person1 = new VipPerson();
        System.out.println(person1.getName());

        VipPerson person2 = new VipPerson("person2", 25000.00);
        System.out.println(person2.getName());

        VipPerson person3 = new VipPerson("Third", 100.00, "third@email.com");
        System.out.println(person3.getName());
        System.out.println(person3.getEmailAddress());


    }
}
