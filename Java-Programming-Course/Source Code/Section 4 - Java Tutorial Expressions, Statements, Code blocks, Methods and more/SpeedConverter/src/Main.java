public class Main {

    public static void main(String[] args) {

        double miles = SpeedConverter.toMilesPerHour(10.5);
        System.out.println("Miles = " + miles);

        SpeedConverter.printConversion(10.5);

        MegaBytesConverter.printMegaBytesAndKiloBytes(2500);

        boolean shouldWakeUp = BarkingDog.shouldWakeUp(true, 1);

        boolean isLeapYear = LeapYear.isLeapYear(2020);

        DecimalComparator.areEqualByThreeDecimalPlaces(-5.123, 5.1234);

        boolean hasEqualSum = EqualSumChecker.hasEqualSum(1, 1, 2);

        boolean hasTeen = TeenNumberChecker.hasTeen(26, 05, 15);

        boolean isTeen = TeenNumberChecker.isTeen(16);

    }
}
