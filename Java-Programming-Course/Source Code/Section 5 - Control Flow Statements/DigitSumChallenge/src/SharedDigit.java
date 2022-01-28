public class SharedDigit {

    public static boolean hasSharedDigit(int firstNumber, int secondNumber)
    {
        if(firstNumber < 10 || secondNumber < 10 || firstNumber > 99 || secondNumber > 99)
        {
            return false;
        }

        int num1 = firstNumber % 10;
        int num2 = firstNumber / 10;
        int num3 = secondNumber % 10;
        int num4 = secondNumber / 10;

        return (num1 == num3) || (num1 == num4) || (num2 == num3) || (num2 == num4);

    }
}
