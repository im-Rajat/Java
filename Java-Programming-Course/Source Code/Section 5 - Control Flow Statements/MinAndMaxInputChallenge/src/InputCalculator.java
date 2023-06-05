import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage()
    {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;

        while (true)
        {
//            System.out.println("Enter Number : ");
            boolean isAnInt = scanner.hasNextInt();

            if(isAnInt)
            {
                int number = scanner.nextInt();
                sum += number;
                count++;
            }
            else
            {
                break;
            }

            scanner.nextLine();
        }

        if(count != 0)
        {
            double average = (double) sum / (double) count;
//            System.out.println(average);
            System.out.println("SUM = " + sum + " AVG = " + Math.round(average));
        }
        else
        {
            System.out.println("SUM = 0 AVG = 0");
        }


        scanner.close();
    }
}
