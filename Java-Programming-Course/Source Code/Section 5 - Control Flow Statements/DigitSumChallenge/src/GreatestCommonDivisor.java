public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int first, int second)
    {
        if(first < 10 || second < 10)
        {
            return -1;
        }

        while (first != second)
        {
            if(first > second)
            {
                first = first - second;
            }
            else
                second = second - first;
        }
        return first;
    }

    public static int getGreatestCommonDivisorRecursive(int first, int second)
    {
        if(first < 10 || second < 10)
        {
            return -1;
        }

        return gcd(first, second);
    }

    public static int gcd(int first, int second)
    {
        if(second == 0)
        {
            return first;
        }

        return gcd(second, first % second);
    }
}
