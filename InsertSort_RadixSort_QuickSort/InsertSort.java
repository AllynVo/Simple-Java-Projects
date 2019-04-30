/*
 * Allyn Vo
 * CS 302
 * Date:
 * Assignment: Lab 2 - Sorting
 */
package lab2;

import static lab2.Lab2.print;
import static lab2.Lab2.swap;

/**
 *
 * @author allynvo
 */
public class InsertSort {
////////////////////////////////////////////////////////////////////////////////
// Method: Insert Sort
////////////////////////////////////////////////////////////////////////////////

    public static void runInsertSort(int[] input) {
        int arr[] = input;//arr[]
        int length = arr.length;
        System.out.println("Before sort:");
        print(arr, length);

        //Timer
        long start, end;
        start = System.nanoTime();
        insertSort(arr);
        end = System.nanoTime();

        System.out.println("\nAfter sort:");
        print(arr, length);

        //print insert sort nano time
        System.out.println("\nnanoTime: " + (end - start));
    }

    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j, j - 1);
            }
        }//for
        return arr;
    }//insertSort

}
