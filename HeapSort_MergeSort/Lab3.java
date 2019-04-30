/*
 * Allyn Vo
 * CS 302
 * Date: 10/23/2017
 * Assignment: Lab 3
 */
package lab3;

/**
 *
 * @author allynvo
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     *
     * For the given array, all three sorts (Insert, merge, heap) took about 0
     * milliseconds. Using nanoTime and with 22 given arrays: Insert > Heap >
     * Merge
     *
     * For the randomly generated array of size 1000: - Heap Sort takes about 1
     * millisecond, 0 and 2 being the rare case - Merge Sort takes about 1
     * millisecond, 0 being the rare case - Insert Sort takes about 4-6
     * milliseconds, 7 being a rare case In nanoTime for the random arrays:
     * Insert took the longest for sure; Heap and Merge sorts were back and
     * forth or even, but merge sort tended to come out faster more often.
     *
     * In CS , Priority Queue (PQ) is an abstract data type which is like a
     * regular queue or stack data structure, but where additionally each
     * element has a "priority" (more importance). Nodes in PQ hold the value of
     * priority.
     *
     * In a PQ, an element with high priority is served before an element with
     * low priority. If two elements have the same priority, they are served
     * according to their order in the queue.
     *
     * A PQ is an abstract concept like a "list" or a "map"; just as a list can
     * be implemented with a linked list or an array, a PQ can be implemented
     * with a heap or a variety of other methods such as an unordered array.
     *
     * PQ can be implemented in heaps, Huffman codes, and other not as efficient
     * data structures: array, linked list, binary search tree.
     */
    public static void main(String[] args) {
        givenArraySorts();

        randomArraySorts();
    }

    public static void givenArraySorts() {
        // Heap Sort
        int arr[] = {129, 24, 15, 135, 87, 275, 99, 120, 32, 44,
            152, 127, 23, 105, 89, 134, 69, 42, 140, 217, 85, 46};
        HeapSort hs = new HeapSort();

        System.out.println("Given Array: ");
        hs.printArray(arr);

        long start = System.nanoTime();
        hs.sort(arr);
        long end = System.nanoTime();
        long time = end - start;

        System.out.println("Heap Sorted Array: ");
        hs.printArray(arr);
        System.out.println("Heap Sort Time: " + time);

        // Merge Sort
        System.out.println();
        int arr2[] = {129, 24, 15, 135, 87, 275, 99, 120, 32, 44,
            152, 127, 23, 105, 89, 134, 69, 42, 140, 217, 85, 46};
        MergeSort ms = new MergeSort();

        System.out.println("Given Array: ");
        ms.printArray(arr2);

        start = System.nanoTime();
        ms.sort(arr2, 0, arr.length - 1);
        end = System.nanoTime();
        time = end - start;

        System.out.println("Merge Sorted Array: ");
        ms.printArray(arr2);
        System.out.println("Merge Sort Time: " + time);

        // Insert Sort
        System.out.println();
        int arr3[] = {129, 24, 15, 135, 87, 275, 99, 120, 32, 44,
            152, 127, 23, 105, 89, 134, 69, 42, 140, 217, 85, 46};

        System.out.println("Given Array: ");
        print(arr3, arr3.length);

        start = System.nanoTime();
        insertSort(arr3);
        end = System.nanoTime();
        time = end - start;

        System.out.println("Insert Sorted Array: ");
        print(arr3, arr3.length);
        System.out.println("Insert Sort Time: " + time);
    }

    public static void randomArraySorts() {
        //RANDOM GENERATED ARRAY OF 1000 NUMBERS, FROM 0-5000
        int[] randomArr = new int[1000];
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = (int) (Math.random() * 5000 + 1);
        }

        // Heap Sort of random array
        int arr[] = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = randomArr[i];
        }

        HeapSort hs = new HeapSort();

        System.out.println("Given Array: ");
        hs.printArray(arr);

        long start = System.currentTimeMillis();
        hs.sort(arr);
        long end = System.currentTimeMillis();
        long time = end - start;

        System.out.println("Heap Sorted Array: ");
        hs.printArray(arr);
        System.out.println("Heap Sort Time: " + time);

        // Merge Sort of random array
        System.out.println();
        int arr2[] = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr2[i] = randomArr[i];
        }

        MergeSort ms = new MergeSort();

        System.out.println("Given Array: ");
        ms.printArray(arr2);

        start = System.currentTimeMillis();
        ms.sort(arr2, 0, arr.length - 1);
        end = System.currentTimeMillis();
        time = end - start;

        System.out.println("Merge Sorted Array: ");
        ms.printArray(arr2);
        System.out.println("Merge Sort Time: " + time);

        // Insert Sort of random array
        System.out.println();
        int arr3[] = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr3[i] = randomArr[i];
        }

        System.out.println("Given Array: ");
        print(arr3, arr3.length);

        start = System.currentTimeMillis();
        insertSort(arr3);
        end = System.currentTimeMillis();
        time = end - start;

        System.out.println("Insert Sorted Array: ");
        print(arr3, arr3.length);
        System.out.println("Insert Sort Time: " + time);
    }

    //Insert Sort Method
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j, j - 1);
            }
        }//for
        return arr;
    }//insertSort

    public static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //Swap method, swaps in array
    public static void swap(int arr[], int position1, int position2) {
        int holder = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = holder;
    }//swap

    /*
    * Implement a timer that will time all methods separately 
    * and store each value.
    * This will be use to compare runtimes:
    * System.currentTimeMillis();
     */
 /*
    * For all sort algorithms sort: 129, 24, 15,135, 87, 275, 99, 120, 32, 44, 
    * 152, 127, 23, 105, 89, 134, 69, 42, 140, 217, 85, 46
    * In comments at the very top of the class containing the main, explain the 
    * results of the code.
     */
 /*
    * For all sort algorithms sort: create an array of 1000 random values 
    * between 0 and 5000.
    * Once again run the code and time the sort methods separately.
    * Compare the runtime and explain in comments at the top of the class main.
     */
 /*
    In comments explain, at the top of the class with the main method,
    Priority Queues. 
    You should explain in depth what a priority queue is and what it supports 
    in terms of nodes. How does it stay balanced? What kind of sort can be used? 
    What are some implementations? 
     */
}
