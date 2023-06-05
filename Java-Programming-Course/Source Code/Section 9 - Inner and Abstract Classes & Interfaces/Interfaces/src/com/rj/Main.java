package com.rj;

public class Main {

    public static void main(String[] args) {

        ITelephone RJPhone;
        RJPhone = new DeskPhone(1234);
        RJPhone.powerOn();
        RJPhone.callPhone(1234);
        RJPhone.answer();

        RJPhone = new MobilePhone(1212);
        RJPhone.powerOn();
        RJPhone.callPhone(1212);
        RJPhone.answer();
    }
}
