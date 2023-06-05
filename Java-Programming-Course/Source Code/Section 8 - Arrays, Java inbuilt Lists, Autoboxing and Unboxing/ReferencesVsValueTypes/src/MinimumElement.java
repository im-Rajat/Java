import java.util.Scanner;

public class MinimumElement {

//    public static Scanner scanner = new Scanner(System.in);

    private static int readInteger()
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        return number;
    }

    private static int[] readElements(int number)
    {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[number];
        for(int i=0; i<number; i++)
        {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }

    private static int findMin(int[] array)
    {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<array.length; i++)
        {
            min = Integer.min(min, array[i]);
        }
        return min;
    }

//    private static int findMax(int[] array)
//    {
//        int max = Integer.MIN_VALUE;
//        for(int i=0; i<array.length; i++)
//        {
//            max = Integer.max(max, array[i]);
//        }
//        return max;
//    }

}
