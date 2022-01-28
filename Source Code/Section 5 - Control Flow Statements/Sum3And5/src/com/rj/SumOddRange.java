package com.rj;

public class SumOddRange {

    public static boolean isOdd(int number)
    {
        if(number > 0 && number % 2 == 1)
        {
            return true;
        }

        return false;
    }

    public static int sumOdd(int start, int end)
    {
        if(end < 0 || start < 0 || end < start)
            return -1;

        int sum = 0;

        for(int i=start; i<=end; i++)
        {
            if(isOdd(i))
            {
                sum += i;
            }
        }
        return sum;
    }
}
