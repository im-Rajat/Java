package com.rj;

public class Main {

    public static void main(String[] args) {

        // below lines are called as statements (that have expression)
        int myVariable=50;
        if(myVariable == 50) {
            System.out.println("Printed");
        }
        // indentation is important

        myVariable++;
        myVariable--;
        System.out.println("This is a test");

        System.out.println("This is" +
                " another" +
                " still more.");

        int anotherVariable = 50;myVariable--;System.out.println("This is anothero one");
    }
}
