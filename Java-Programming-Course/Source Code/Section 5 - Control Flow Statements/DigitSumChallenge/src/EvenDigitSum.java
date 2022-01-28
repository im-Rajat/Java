public class EvenDigitSum {

    public static int getEvenDigitSum(int number)
    {
        if(number < 0)
        {
            return -1;
        }

        int sum = 0;
        while(number > 10)
        {
            int digit = number % 10;
            if(digit % 2 == 0)
            {
                sum = sum + digit;
            }
            number = number / 10;
        }

        if(number % 2 == 0)
        {
            sum = sum + number;
        }

        return sum;
    }
}
