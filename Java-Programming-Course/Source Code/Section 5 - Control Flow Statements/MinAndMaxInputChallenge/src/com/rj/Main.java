package com.rj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (true)
        {
            System.out.println("Enter Number : ");
            boolean isAnInt = scanner.hasNextInt();
            if(isAnInt)
            {
                int number = scanner.nextInt();
                max = Integer.max(max, number);
                min = Integer.min(min, number);
            }
            else
            {
                break;
            }
            scanner.nextLine();
        }

        System.out.println("Maximum Number : " + max);
        System.out.println("Minimun Number : " + min);

        scanner.close();

    }
}
