public class NumberToWords {

    public static void numberToWords(int number)
    {
        if(number < 0)
        {
            System.out.println("Invalid Value");
        }

        if (number == 0)
        {
            System.out.println("Zero");
            return;
        }

        int reverseNumber = reverse(number);

        String numToWords = "";

        int reverseNumberTemp = reverseNumber;

        while (reverseNumberTemp > 0)
        {
            int digit = reverseNumberTemp % 10;

            switch(digit)
            {
                case 0:
                    numToWords = numToWords + "Zero ";
                    break;
                case 1:
                    numToWords = numToWords + "One ";
                    break;
                case 2:
                    numToWords = numToWords + "Two ";
                    break;
                case 3:
                    numToWords = numToWords + "Three ";
                    break;
                case 4:
                    numToWords = numToWords + "Four ";
                    break;
                case 5:
                    numToWords = numToWords + "Five ";
                    break;
                case 6:
                    numToWords = numToWords + "Six ";
                    break;
                case 7:
                    numToWords = numToWords + "Seven ";
                    break;
                case 8:
                    numToWords = numToWords + "Eight ";
                    break;
                case 9:
                    numToWords = numToWords + "Nine ";
                    break;

                default:
                    numToWords = numToWords + "Invalid Value";
                    break;

            }

//            numToWords = numToWords + digitToWord(digit);
            reverseNumberTemp = reverseNumberTemp / 10;
        }

        int digitCount1 = getDigitCount(number);
        int digitCount2 = getDigitCount(reverseNumber);

        int addZero = 0;
        if(digitCount1 != digitCount2)
        {
            addZero = digitCount1 - digitCount2;
        }

        while (addZero > 0)
        {
            numToWords = numToWords + "Zero ";
            addZero--;
        }

        System.out.println(numToWords);

    }

    public static int getDigitCount(int number)
    {
        if(number < 0)
        {
            return -1;
        }

        int digitCount = 0;

        if (number == 0)
        {
            return 1;
        }

        while (number != 0)
        {
            digitCount++;
            number = number / 10;
        }

        return digitCount;
    }

    public static int reverse(int number)
    {
        int reverse = 0;

        while (number!=0)
        {
            reverse = (reverse * 10) + (number % 10);
            number = number / 10;
        }

        return reverse;
    }

    /*public static String digitToWord(int number)
    {
        switch(number)
        {
            case 0:
                return "Zero ";
            case 1:
                return "One ";
            case 2:
                return "Two ";
            case 3:
                return "Three ";
            case 4:
                return "Four ";
            case 5:
                return "Five ";
            case 6:
                return "Six ";
            case 7:
                return "Seven ";
            case 8:
                return "Eight ";
            case 9:
                return "Nine ";

            default:
                return "Invalid Value";
        }
    }*/
}
