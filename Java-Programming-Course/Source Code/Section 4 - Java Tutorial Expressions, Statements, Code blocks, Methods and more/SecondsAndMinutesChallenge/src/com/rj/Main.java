package com.rj;

public class Main {

    public static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {

        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3945L));

        double area = AreaCalculator.area(5.0);
        area = AreaCalculator.area(5.0, 4.0);

        MinutesToYearsDaysCalculator.printYearsAndDays(561600);
        MinutesToYearsDaysCalculator.printYearsAndDays(1051200);
        MinutesToYearsDaysCalculator.printYearsAndDays(561600);

        IntEqualityPrinter.printEqual(1, 1, 1);
        IntEqualityPrinter.printEqual(1, 1, 2);
        IntEqualityPrinter.printEqual(-1, -1, -1);
        IntEqualityPrinter.printEqual(1, 2, 3);

        boolean isCatPlaying = PlayingCat.isCatPlaying(true, 10);
        isCatPlaying = PlayingCat.isCatPlaying(false, 36);
        isCatPlaying = PlayingCat.isCatPlaying(false, 35);

    }

    public static String getDurationString(long minutes, long seconds) {

        if ( (minutes < 0) || (seconds < 0) || (seconds >59) )
        {
            return INVALID_VALUE_MESSAGE;
        }

        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;

        String hoursString = hours + "h ";
        if(hours < 10)
        {
            hoursString = "0" + hoursString;
        }

        String minutesString = remainingMinutes + "m ";
        if(remainingMinutes < 10)
        {
            minutesString = "0" + minutesString;
        }

        String secondsString = seconds + "s";
        if(seconds < 10)
        {
            secondsString = "0" + secondsString;
        }

        return hoursString + minutesString + secondsString;
    }

    public static String getDurationString(long seconds) {

        if(seconds < 0)
        {
            return INVALID_VALUE_MESSAGE;
        }

        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }

}
