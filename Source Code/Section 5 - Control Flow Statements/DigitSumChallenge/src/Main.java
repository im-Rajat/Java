public class Main {

    public static void main(String[] args)
    {
        System.out.println(NumberPalindrome.isPalindrome(11));

        System.out.println();

        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(5));

        System.out.println();

        System.out.println(EvenDigitSum.getEvenDigitSum(123456789));
        System.out.println(EvenDigitSum.getEvenDigitSum(2000));

        System.out.println();

        System.out.println(SharedDigit.hasSharedDigit(12, 23));
        System.out.println(SharedDigit.hasSharedDigit(100, 10));

        System.out.println();

        System.out.println(LastDigitChecker.hasSameLastDigit(41, 22, 71));
        System.out.println(LastDigitChecker.hasSameLastDigit(23, 32, 42));
        System.out.println(LastDigitChecker.hasSameLastDigit(9, 99, 999));

        System.out.println();

        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisor(25, 15));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisor(9, 18));

        System.out.println();

        FactorPrinter.printFactors(32);
        FactorPrinter.printFactors(-1);

        System.out.println();

        System.out.println(PerfectNumber.isPerfectNumber(28));
        System.out.println(PerfectNumber.isPerfectNumber(5));

        System.out.println();

        System.out.println(NumberToWords.getDigitCount(0));
        NumberToWords.numberToWords(100);

    }
}
