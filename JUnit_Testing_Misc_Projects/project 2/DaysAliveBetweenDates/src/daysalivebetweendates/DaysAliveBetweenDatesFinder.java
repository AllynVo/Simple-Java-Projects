/*
 * the method to test is here.
 */
package daysalivebetweendates;

/**
 * @ since 4-3-17
 * @author lulofse
 */
public class DaysAliveBetweenDatesFinder {

    public int getsDaysBetweenDates(
            int birthMonth, int birthDay, int birthYear,
            int todayMonth, int todayDay, int todayYear) {
        int months, days, years;

        if (birthYear > todayYear) {
            return -1;
        }
        months = todayMonth - birthMonth;
        days = todayDay - birthDay;
        days += 30 * months;
        days += 365 * (todayYear - birthYear);
        return days;
    }

}
