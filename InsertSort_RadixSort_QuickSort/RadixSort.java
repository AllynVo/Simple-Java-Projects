/*
 * Allyn Vo
 * CS 302
 * Date:
 * Assignment: Lab 2 - Sorting
 */
package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import static lab2.Lab2.print;

/**
 *
 * @author allynvo
 */
public class RadixSort {

    ////////////////////////////////////////////////////////////////////////////////
// Method: Radix Sort
////////////////////////////////////////////////////////////////////////////////
    public static void radixSort(int arr[], int n) {
        //Find biggest number to know how many digit places
        int max = getMax(arr, n);

        //Sort for each digit in the biggest number
        //i is the digits place
        print(arr, arr.length);
        System.out.println();
        for (int i = 1; max / i > 0; i = i * 10) {
            rSort(arr, n, i);
            print(arr, arr.length);
            System.out.println();
        }//for
    }//radixSort

    //Gets the max of an array
    public static int getMax(int arr[], int n) {
        int max = arr[0];//starting point
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }//if
        }//for
        return max;
    }//getMax

    //does the counting sort of an array depending on which digit of exponent(i)
    public static void rSort(int arr[], int n, int i) {
        int output[] = new int[n];
        int j;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (j = 0; j < n; j++) {
            count[(arr[j] / i) % 10]++;
        }//for

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (j = 1; j < 10; j++) {
            count[j] += count[j - 1];
        }//for

        // Build the output array
        for (j = n - 1; j >= 0; j--) {
            output[count[(arr[j] / i) % 10] - 1] = arr[j];
            count[(arr[j] / i) % 10]--;
        }//for

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (j = 0; j < n; j++) {
            arr[j] = output[j];
        }//for
    }

////////////////////////////////////////////////////////////////////////////////
// Method: String radix sort
////////////////////////////////////////////////////////////////////////////////   
    public static void countingRadixSort(String[] arr1, int stringLen) {
        //buckets for ascii
        final int BUCKETS = 256;

        int N = arr1.length;
        //temporary holders
        String[] buffer = new String[N];

        String[] in = arr1;
        String[] out = buffer;

        //goes through each postion of the strings. Is a fixed position
        for (int pos = stringLen - 1; pos >= 0; pos--) {

            int[] count = new int[BUCKETS + 1];

            for (int i = 0; i < N; i++) {
                count[in[i].charAt(pos) + 1]++;
            }

            for (int b = 1; b <= BUCKETS; b++) {
                count[b] += count[b - 1];
            }

            for (int i = 0; i < N; i++) {
                out[count[in[i].charAt(pos)]++] = in[i];
            }

            // swap in and out roles
            String[] tmp = in;
            in = out;
            out = tmp;
            print(in, in.length);
            System.out.println();
        }

        // if odd number of passes, in is buffer, out is arr; so copy back
        if (stringLen % 2 == 1) {
            for (int i = 0; i < arr1.length; i++) {
                out[i] = in[i];
            }
        }
    }

}
