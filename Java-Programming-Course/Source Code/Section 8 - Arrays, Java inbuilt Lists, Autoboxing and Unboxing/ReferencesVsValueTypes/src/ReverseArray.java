import java.util.Arrays;

public class ReverseArray {

    private static void reverse(int[] array)
    {
        System.out.println("Array = " + Arrays.toString(array));
        int i = 0;
        int j = array.length - 1;
        while(i < j)
        {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        System.out.println("Reversed array = " + Arrays.toString(array));
    }
}
