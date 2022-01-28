public class NumberPalindrome {

    public static boolean isPalindrome(int number)
    {
        number = Math.abs(number);

        int reverse = 0;
        int num = number;
        while(num > 0)
        {
            reverse = (reverse * 10) + (num % 10);
            num = num / 10;
        }

        System.out.println(reverse);

        if(number == reverse)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
