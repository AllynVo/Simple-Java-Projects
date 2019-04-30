/*
 * Allyn Vo
 * CS 302
 * Date:
 * Assignment: Lab 2 - Sorting
 */
package lab2;

import java.util.Random;
import static lab2.Lab2.print;
import static lab2.Lab2.swap;

/**
 *
 * @author allynvo
 */
public class QuickSort {
////////////////////////////////////////////////////////////////////////////////
// Method: Quick Sort, high
////////////////////////////////////////////////////////////////////////////////

    /*
    arr[] = array to be sorted
    low = First index
    high = Last index
     */
    public static void quickSortHigh(int arr[], int low, int high) {

        if (low < high) {
            //pi = partitioning index
            //arr[pi] gets set to right place
            int pi = partitionHigh(arr, low, high);

            //Recursively sort elements before partition index
            quickSortHigh(arr, low, pi - 1);

            //Recursively sort elements after partition index
            quickSortHigh(arr, pi + 1, high);
        }//if  

    }//quickSort

    //partition method
    public static int partitionHigh(int arr[], int low, int high) {
        int pivot = arr[high];
        //prints
        //print(arr, arr.length);
        System.out.print(pivot + " ");
        int i = low - 1;//smaller index element

        for (int j = low; j < high; j++) {
            //if the current element <= pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }//if
        }//for

        swap(arr, i + 1, high);
        return i + 1;
    }//partition
////////////////////////////////////////////////////////////////////////////////
// Method: Quick Sort, low
////////////////////////////////////////////////////////////////////////////////

    public static void quickSortLow(int arr[], int low, int high) {

        if (low < high) {
            //pi = partitioning index
            //arr[pi] gets set to right place
            int pi = partitionLow(arr, low, high);

            //Recursively sort elements before partition index
            quickSortLow(arr, low, pi - 1);

            //Recursively sort elements after partition index
            quickSortLow(arr, pi + 1, high);
        }//if  

    }//quickSort

    //partition method
    public static int partitionLow(int arr[], int low, int high) {
        int pivot = arr[low];
        //prints
        //print(arr, arr.length);
        System.out.print(pivot + " ");
        int i = low - 1;//smaller index element

        for (int j = low; j < high; j++) {
            //if the current element <= pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }//if
        }//for

        swap(arr, i + 1, high);
        return i + 1;
    }//partition    

////////////////////////////////////////////////////////////////////////////////
// Method: Quick Sort, average
////////////////////////////////////////////////////////////////////////////////
    public static void quickSortAvg(int arr[], int low, int high) {

        if (low < high) {
            //pi = partitioning index
            //arr[pi] gets set to right place
            int pi = partitionAvg(arr, low, high);

            //Recursively sort elements before partition index
            quickSortAvg(arr, low, pi - 1);

            //Recursively sort elements after partition index
            quickSortAvg(arr, pi + 1, high);
        }//if  

    }//quickSort

    //partition method
    public static int partitionAvg(int arr[], int low, int high) {
        // (first + middle + last) / 3. To get average
        int pivot = (arr[low] + arr[low + (high - low) / 2] + arr[high]) / 3;
        //prints
        //print(arr, arr.length);
        System.out.print(pivot + " ");
        int i = low - 1;//smaller index element

        for (int j = low; j < high; j++) {
            //if the current element <= pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }//if
        }//for

        swap(arr, i + 1, high);
        return i + 1;
    }//partition 

////////////////////////////////////////////////////////////////////////////////
// Method: Quick Sort, average
////////////////////////////////////////////////////////////////////////////////
    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static void quickSortRdm(int arr[], int low, int high) {

        if (low < high) {
            //pi = partitioning index
            //arr[pi] gets set to right place
            int pi = partitionRdm(arr, low, high);

            //Recursively sort elements before partition index
            quickSortRdm(arr, low, pi - 1);

            //Recursively sort elements after partition index
            quickSortRdm(arr, pi + 1, high);
        }//if  

    }//quickSort

    //partition method
    public static int partitionRdm(int arr[], int low, int high) {
        // (first + middle + last) / 3. To get average
        int pivot = getRandom(arr);
        //prints
        //print(arr, arr.length);
        System.out.print(pivot + " ");
        int i = low - 1;//smaller index element

        for (int j = low; j < high; j++) {
            //if the current element <= pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }//if
        }//for

        swap(arr, i + 1, high);
        return i + 1;
    }//partition
}
