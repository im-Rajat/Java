package com.rj;

public class VipPerson {

    private String name;
    private double creditLimit;
    private String emailAddress;

    public VipPerson()
    {
        this("Default name", 50000, "default@email.com");
//        System.out.println("Empty constructor called");

    }

    public VipPerson(String name, double creditLimit)
    {
        this(name, creditLimit, "unknows@email.com");
    }

    public VipPerson(String name, double creditLimit, String emailAddress)
    {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
