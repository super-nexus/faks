import java.util.Scanner;
import java.util.ArrayList;

public class DN03_63180178 {

    private static final String space = " ";
    private static final String underscore = "_";
    private static final String plus = "+";
    private static final String x = "x";
    private static final String star = "*";

    // private static ArrayList<Integer> startingDays;
    static int monthsPerYear, daysInMonth, daysInWeek, everyXdaysInWeek, everyHoliday, fromMonth, fromYear, toMonth,
            toYear, currentDay, currentDayInMonth;

    static boolean checkWorkDays = true;
    static boolean checkHolydays = true;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        initialize(sc);

        currentDayInMonth = 1;

        int month = fromMonth;
        int year = fromYear;

        if (everyHoliday == 1000000000) {
            checkHolydays = false;
        }
        if (everyXdaysInWeek > daysInWeek) {
            checkWorkDays = false;
        }

        currentDay = (((fromYear - 1) * monthsPerYear) + (month - 1)) * daysInMonth + currentDayInMonth;

        // printAll();

        while (((month == toMonth + 1) && (year == toYear)) == false) {

            // System.out.printf("Current month: %d, Current Year: %d\n", month, year);

            printMonth(month, year, returnFirstDay(month, year));
            month++;

            if (((month == toMonth + 1) && (year == toYear))) {
                break;
            }
            if (month > monthsPerYear) {
                year++;
                month = 1;
            }

            // System.out.printf("Current month: %d, Current Year: %d\n", month, year);
        }

    }

    private static void printAll() {
        System.out.printf(
                "monthsPerYear: %d\ndaysInMonth: %d\ndaysInWeek: %d\neveryXdaysInweek: %d\neveryHoliday: %d\nfromM: %d\nfromY: %d\ntoM: %d\ntoY: %d\n",
                monthsPerYear, daysInMonth, daysInWeek, everyXdaysInWeek, everyHoliday, fromMonth, fromYear, toMonth,
                toYear);
    }

    public static void initialize(Scanner sc) {

        monthsPerYear = sc.nextInt();
        daysInMonth = sc.nextInt();
        daysInWeek = sc.nextInt();
        everyXdaysInWeek = sc.nextInt();
        everyHoliday = sc.nextInt();

        fromMonth = sc.nextInt();
        fromYear = sc.nextInt();

        toMonth = sc.nextInt();
        toYear = sc.nextInt();
    }


    public static String returntypeOfDay(int m){

 

        if(checkWorkDays && checkHolydays){
            if(m % everyXdaysInWeek == 0){

                if(currentDay == 1){
                    return x;
                }

                if(currentDay % everyHoliday == 0){
                    return star;
                }
                else{
                    return x;
                }
    
            }
            else if(currentDay % everyHoliday == 0){
                return plus;
            }
            else{
                return underscore;
            }
        }
        if(checkWorkDays){

            if(currentDay == 1){
                return x;
            }

            if(m % everyXdaysInWeek == 0){
                return x;
            }
            else{
                return underscore;
            }
        }

        if(checkHolydays){
            if(currentDay % everyHoliday == 0){
                return star;
            }
            else{
                return underscore;
            }
        }
        return underscore;
    }

    public static int returnFirstDay(int month, int year) {
        return (daysInWeek - ((((year - 1) * monthsPerYear) + month - 1) * daysInMonth) % daysInWeek);
    }

    public static void printMonth(int month, int year, int firstDay) {

        System.out.printf("%d/%d\n", month, year);

        printWeek(firstDay);

        int daysMinusFirstWeek = daysInMonth - firstDay;
        int divider = daysMinusFirstWeek / daysInWeek;

        int weeksInMonth = (((daysMinusFirstWeek % daysInWeek) == 0) ? divider : divider + 1);

        for (int i = 0; i < weeksInMonth; i++) {
            printWeek(daysInWeek);
        }

    }

    private static void printWeek(int firstDay) {
        String typeOfDay = underscore;
        String toPrint = "";
        int offset = daysInWeek - firstDay;

        for (int m = 1; m <= daysInWeek; m++) {

           // System.out.print("Day: " + currentDay);

            if (offset >= m) {
                toPrint += space.repeat(5);
                continue;
            }

            typeOfDay = returntypeOfDay(m);
  

            if (currentDayInMonth < 10) {
                toPrint += space.repeat(3) + currentDayInMonth + typeOfDay;
            } else {
                toPrint += space.repeat(2) + currentDayInMonth + typeOfDay;
            }

            if (currentDayInMonth == daysInMonth) {
                // toPrint += "\n";
                currentDayInMonth = 1;
                currentDay++;
                break;
            }
            currentDayInMonth++;
            currentDay++;

        }
        toPrint += "\n";
        System.out.print(toPrint);
    }

};