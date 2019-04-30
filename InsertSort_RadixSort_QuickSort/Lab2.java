/*
 * Allyn Vo
 * CS 302
 * Date:
 * Assignment: Lab 2 - Sorting
 */
package lab2;

import java.util.*;

/**
 *
 * @author allynvo
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input;

        //GIVEN ARRAY IN LAB INSTRUCTIONS
        int givenArr[] = {129, 24, 15, 135, 87,
            275, 99, 120, 32, 44,
            152, 127, 23, 105, 89,
            134, 69, 42, 140, 217,
            85, 46};

        //RANDOM GENERATED ARRAY OF 1000 NUMBERS, FROM 0-5000
        int[] randomArr = new int[1000];
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = (int) (Math.random() * 5000 + 1);

        }
        do {
            //New Scanner
            Scanner scanInput = new Scanner(System.in);

            //Instructions
            System.out.println();
            System.out.println("==================== MENU ====================");
            System.out.println("  | # | What would you like to complete? ");
            System.out.println("  | 1 | Insert sort");
            System.out.println("E | 2 | Quick sort, last pivot");
            System.out.println("N | 3 | Quick sort, first pivot");
            System.out.println("T | 4 | Quick sort, average pivot");
            System.out.println("E | 5 | Quick sort, random pivots");
            System.out.println("R | 6 | To exit");
            System.out.println("  | 7 | Radix sort");
            System.out.println("  | 8 | String radix sort");
            System.out.println("----------------------------------------------");

            //Get users entry for cases
            input = scanInput.next();

            //Switch Menu
            switch (input) {
                // O(1),O(log n) > O(n) > O(n log n) > O(n^2) > O(2^n) > O(n!)
                case "1": //INSERT - fast for small amount, slow for big amount
                    //Best: O(n), Worst:O(n^2)
                    System.out.println("");
                    InsertSort.runInsertSort(givenArr);
                    System.out.println();
                    InsertSort.runInsertSort(randomArr);

                    System.exit(0);
                
                case "2": //QUICK USING LAST - fast for small amount, slow for big amount
                    //Best: O(n log n), Avg: O(n log n), Worst:O(n^2)
                    System.out.println("");
                    System.out.print("Given array using last Pivots: ");
                    long start, end;
                    start = System.nanoTime();
                    QuickSort.quickSortHigh(givenArr, 0, (givenArr.length - 1));
                    end = System.nanoTime();
                    System.out.println("\nnanoTime: " + (end - start));

                    System.out.println();
                    System.out.print("Random array Pivots: ");
                    start = System.nanoTime();
                    QuickSort.quickSortHigh(randomArr, 0, (randomArr.length - 1));
                    end = System.nanoTime();
                    System.out.println("\nnanoTime: " + (end - start));

                    System.exit(0);

                case "3": //QUICK USING FIRST - like using first, or last indexes. Like a hit or miss if it's fast or slow
                    System.out.println("");
                    System.out.print("Given array using first Pivots: ");
                    start = System.nanoTime();
                    QuickSort.quickSortLow(givenArr, 0, (givenArr.length - 1));
                    end = System.nanoTime();
                    System.out.println("\nnanoTime: " + (end - start));
                    System.exit(0);

                case "4": //QUICK USING AVERAGES - more efficient than using first/last indexes
                    System.out.println("");
                    System.out.print("Given array using average Pivots: ");
                    start = System.nanoTime();
                    QuickSort.quickSortAvg(givenArr, 0, (givenArr.length - 1));
                    end = System.nanoTime();
                    System.out.println("\nnanoTime: " + (end - start));
                    System.exit(0);

                case "5": //QUICK USING RANDOMS - literally, random
                    System.out.println("");
                    System.out.print("Given array using random Pivots: ");
                    start = System.nanoTime();
                    QuickSort.quickSortRdm(givenArr, 0, (givenArr.length - 1));
                    end = System.nanoTime();
                    System.out.println("\nnanoTime: " + (end - start));
                    System.exit(0);

                case "6": //EXIT
                    System.out.println("Thanks! Exited.\n -Allyn");
                    System.exit(0);

                case "7": //RADIX - fast in general
                    //Best/Avg/Worst: O(n)
                    System.out.println("");
                    start = System.nanoTime();
                    RadixSort.radixSort(givenArr, (givenArr.length - 1));
                    end = System.nanoTime();
                    System.out.println("\nnanoTime: " + (end - start));

                    System.out.println();
                    System.out.print("Random array: ");
                    start = System.nanoTime();
                    RadixSort.radixSort(randomArr, (randomArr.length - 1));
                    end = System.nanoTime();
                    System.out.println("\nnanoTime: " + (end - start));

                    System.exit(0);

                case "8": //RADIX USING STRINGS
                    System.out.println("");
                    String arr1[] = {"Allyn", "Kevin", "Carlo", "Jarrr"};
                    int stringLength = 5;
                    start = System.nanoTime();
                    RadixSort.countingRadixSort(arr1, stringLength);
                    end = System.nanoTime();
                    System.out.println("\nnanoTime: " + (end - start));
                    System.exit(0);

                default: //DEFAULT
                    System.out.println("Invlaid option.");
                    break;

            }
        } while (!input.equals("6"));

    }
//Method to swap two indexes of an array

    public static void swap(int arr[], int position1, int position2) {
        int holder = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = holder;
    }//swap

    //print array methodS
    public static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void print(String arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}//End of lab2 class

