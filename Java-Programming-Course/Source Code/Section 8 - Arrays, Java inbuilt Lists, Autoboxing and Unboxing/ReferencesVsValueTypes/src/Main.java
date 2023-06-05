import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        int[] array = {5, 4, 3, 2, 1};
        System.out.println("Original Array = " + Arrays.toString(array));
        ReverseArray.reverse(array);
        System.out.println("Reverse Array = " + Arrays.toString(array));
    }
}
