public class LastDigitChecker {

    public static boolean hasSameLastDigit(int num1, int num2, int num3)
    {
//        if(num1 < 10 || num2 < 10 || num3 < 10 || num1 > 1000 || num2 > 1000 || num3 > 1000)
//        {
//            return false;
//        }

        if( !(isValid(num1) && isValid(num2) && isValid(num3)) )
        {
            return false;
        }

        int lastDigit1 = num1 % 10;
        int lastDigit2 = num2 % 10;
        int lastDigit3 = num3 % 10;

        if(lastDigit1 == lastDigit2 || lastDigit1 == lastDigit3 || lastDigit2 == lastDigit3)
        {
            return true;
        }

        return false;
    }

    public static boolean isValid(int num)
    {
        if(num < 10 || num > 1000)
        {
            return false;
        }

        return true;
    }

}
