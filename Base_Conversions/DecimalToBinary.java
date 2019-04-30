//Allyn Vo
//ID: 36835977
//April 4, 2017
//CS 311
//Decimal to binary number conversion
package basenumberconversion;

import java.util.*;

/**
 *
 * @author Allyn Vo
 */
public class DecimalToBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // New Scanner
        Scanner input = new Scanner(System.in);

        // Ask user for decimal / base 10 number
        System.out.print("Enter a base 10 (Decimal) number: ");
        int number = input.nextInt();

        int base = 2;

        // Algorithm 2        
        // Base 10 to 2 or decimal to binary conversion
        int quotient = number;
        int remainder = 0;
        int binary = 0;
        int increment = 1;
        while (quotient != 0) {
            increment = increment * 10;

            remainder = quotient % base;
            quotient = quotient / base;

            // Adds on the remainders to the binary variable
            binary = binary + (remainder * increment);

        }

        // Prints out binary number
        System.out.println("The equivalent number in base 2 (binary) format is " + (binary / 10));
    }

}
