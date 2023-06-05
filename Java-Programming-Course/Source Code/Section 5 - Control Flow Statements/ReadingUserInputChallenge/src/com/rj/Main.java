package com.rj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int counter = 1;

        while (counter <= 10)
        {
            System.out.println("Enter Number #" + counter + ": ");
            boolean hasAnInt = scanner.hasNextInt();

            if(hasAnInt)
            {
                int number = scanner.nextInt();
                sum += number;
                counter++;
            }
            else
            {
                System.out.println("Invalid Number");
            }

            scanner.nextLine(); // handle end of line (enter key)
        }

        System.out.println("Sum = " + sum);
        scanner.close();
    }
}
