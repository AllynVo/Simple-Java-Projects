/*
 * 2E1 jUnit Test Creation
 * Ch 2 exercise 1

A project with two classes has been created.
Use the given notes in file “Ch 2 jUnit” and our text as a model.
One class has the main and run methods, 
the second class has a method that obtains todays date from the system, 
inputs a birthday (from the keyboard is easiest) 
and calculates the number of days between the two. 
It just use 365 days per year, 30 days per month for simplicity. 

*********************************
1. Use NetBeans to add a jUnit test of method getsDaysBetweenDates
in class DaysAliveBetweenDatesFinder
2. Write a test to see if the method works correctly for the two dates:
a. birthday: April 3, 2017: 4-3-2017
b. today: April 4, 2017: 4-4-2017
I hope that you can see that it should return a value of 1.
So your expected result is 1.

Submit your test jUnit java file and the the jUnit test output 
showing your method passes your tests. Copy and paste the jUnit output 
or take a screen shot.
 */

package daysalivebetweendates;

/**
 *
 * @author lulofse
 * @since 1-6-17
 * DaysAliveBetweenDates
 * Demo-Driver with poor choice of class names: classes are nouns.

 */
public class DaysAliveBetweenDates {

    public static void main(String[] args) {
        new DaysAliveBetweenDates().run();
    }
    
    // The "demo-driver" system always jumps to run immediately.
    public void run(){
        DaysAliveBetweenDatesFinder days = new DaysAliveBetweenDatesFinder();
        
        int daysAliveBetweenDates=0;
        /* public int getsDaysBetweenDates( 
            int birthMonth, int birthDay, int birthYear, 
            int todayMonth, int todayDay, int todayYear ) */
        daysAliveBetweenDates = 
                days.getsDaysBetweenDates(1, 4, 2017, 1, 6, 2017);
        System.out.println("# of days alive= " + daysAliveBetweenDates );
    }    
}
