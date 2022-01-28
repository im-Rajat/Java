public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double numberOne, double numberTwo) {

        numberOne = (int) (numberOne * 1000);
        numberTwo = (int) (numberTwo * 1000);

//        System.out.println(numberOne);
//        System.out.println(numberTwo);

        if(numberOne == numberTwo)
        {
            return true;
        }

        return false;
    }
}
