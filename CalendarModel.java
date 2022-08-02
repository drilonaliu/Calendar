
public class CalendarModel {

    private static final int First_Day_Of_1900 = 1;
    private static final int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static String[][] getMonthArray(int month, int year) {
        String[][] monthArray = new String[6][7];
        int startDay = firstDayOfMonth(month, year);
        int monthDays = totalDaysOfMonth(month, year);
        int day = 1 - (startDay - 1);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (day > 0 && day <= monthDays) {
                    monthArray[i][j] = day + "";
                } else {
                    monthArray[i][j] = "";
                }
                day++;
            }
        }

        return monthArray;
    }

    public static int totalDaysOfMonth(int m, int y) {
        if (m == 2 && isLeapYear(y)) {
            return 29;
        } else {
            return daysOfMonth[m - 1];
        }
    }

    public static boolean isLeapYear(int y) {
        if ((y % 4 == 0) && (((y % 100 == 0 && y % 400 == 0) || (y % 100 != 0)))) {
            return true;
        } else {
            return false;
        }
    }

    public static int firstDayOfMonth(int month, int year) {
        int total_days = (year - 1900) * 365 + countLeapYears(1900, year);
        int total_month_days = countDaysToMonth(month, year);
        int sum = total_days + total_month_days + First_Day_Of_1900;
        if (sum % 7 == 0) {
            return 7;

        } else {
            return sum % 7;
        }
    }

    private static int countLeapYears(int year1, int year2) {
        int count = 0;
        for (int i = year1; i < year2; i++) {
            if (isLeapYear(i)) {
                count += 1;
            }
        }
        return count;
    }

    private static int countDaysToMonth(int month, int year) {
        int count = 0;
        for (int m = 1; m < month; m++) {
            count += totalDaysOfMonth(m, year);
        }
        return count;
    }
}