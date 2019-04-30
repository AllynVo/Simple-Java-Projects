//Allyn Vo
//ID: 36835977
//April 4, 2017
//CS 311
//Base number converion
package basenumberconversion;

import java.util.*;

/**
 *
 * @author Allyn Vo
 */
public class BaseToDecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // New Scanner
        Scanner input = new Scanner(System.in);

        // Ask the suer to enter the required base.
        System.out.print("Please enter a base from 2 - 9: ");
        int base = input.nextInt();

        // Check if the base number is from 2 to 9 inclusive
        boolean correctBase = false;
        while (!correctBase) {
            if (base < 2 || base > 9) {
                System.out.print("Incorrect base system. Please enter a base from 2 - 9: ");
                base = input.nextInt();
                correctBase = false;
            } else {
                correctBase = true;
            }
        }

        // Ask the user to enter the bases number
        System.out.print("Enter a base " + base + " number: ");
        String baseNumberString = input.next();

        // Get length of the number
        int numberLength = baseNumberString.length();

        // Parse number string to integer
        int baseNumber = Integer.parseInt(baseNumberString);

        // Conversion from base number to decimal
        int result = 0;
        int n = numberLength;
        for (int i = 0; i < n; i++) {
            result = (result * base) + Integer.parseInt(baseNumberString.substring(i, (i + 1)));
        }

        // Print result
        System.out.println("The equivalent number in base 10 format is " + result);
    }

}
