package com.rj;

public class Main {

    public static void main(String[] args) {

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float Minimum Value = " + myMinFloatValue);
        System.out.println("Float Maximum Value = " + myMaxFloatValue);

        Double myMinDoubleValue = Double.MIN_VALUE;
        Double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double Minimum Value = " + myMinDoubleValue);
        System.out.println("Double Maximum Value = " + myMaxDoubleValue);

        int myIntValue = 5 / 3;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5.00 / 3.00;
        System.out.println("MyIntValue = " + myIntValue);
        System.out.println("MyFloatValue = " + myFloatValue);
        System.out.println("MyDoubleValue = " + myDoubleValue);

        double numberOfPounds = 200d;
        double convertedKilogram = numberOfPounds * 0.45359237d;
        System.out.println("Converted Kilogram = " + convertedKilogram);

        double pi = 3.1415927d;
        double anotherNumber = 3_000_111.3_121_230d;

        System.out.println(pi);
        System.out.println(anotherNumber);
    }
}
