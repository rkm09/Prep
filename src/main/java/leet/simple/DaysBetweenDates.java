package leet.simple;

public class DaysBetweenDates {
    public static void main(String[] args) {
        String date1 = "2019-06-29";
        String date2 = "2019-06-30";
        int days = daysBetweenDates(date1, date2);
        System.out.println(days);
    }
    public static int daysBetweenDates(String date1, String date2) {
        String[] arr1 = date1.split("-");
        String[] arr2 = date2.split("-");
        int days = 0;
        int diffYear = Math.abs(Integer.valueOf(arr1[0]) - Integer.valueOf(arr2[0]));
        int diffMonth = Math.abs(Integer.valueOf(arr1[1]) - Integer.valueOf(arr2[1]));
        int diffDay = Math.abs(Integer.valueOf(arr1[2]) - Integer.valueOf(arr2[2]));
        if(diffYear > 1) {
            diffYear = diffYear * 365;
        }
        days =  + diffMonth * 30 + diffDay;
        return days;
    }
//    Enum days {
//        JAN(31), FEB(28), MAR(31), APR(30), MAY(30), JUN(31), JUL(30), AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);
//    }
}

/*
Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.



Example 1:

Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1
Example 2:

Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15


Constraints:

The given dates are valid dates between the years 1971 and 2100.
 */
