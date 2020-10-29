/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 * @author
 */
import java.util.Arrays;
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;
    public static void main(String[] args) {
        demoLinearSearchUnsorted();
        demoLinearSearchSorted();
        demoBinarySearchSelectionSort();
        demoBinarySearchFastSort();
    }
    public static int[] generateNumbers(int howMany, int maxValue) {

        if (howMany <= 0) {
            return null;
        }
        int[] storeNumbers = new int[howMany];
        for (int i = 0; i < howMany; i++) {
            int Number = (int)(Math.random() * maxValue);
            storeNumbers[i] = Number;
        }
        return storeNumbers;
    }
    public static boolean linearSearch(int[] data, int search) {

        for (int i = 0; i < data.length; i++) {
            if (data[i] == search) {
                return true;
            }
        }
        return false;
    }
    public static boolean binarySearch(int[] data, int search) {
        int start = 0;
        int end = data.length;
        while (start < end) {
            int middle = (end + start) / 2;

            if (data[middle] == search) {
                return true;

            } else if (data[middle] > search) {
                end = middle;

            } else start = middle + 1;
        }
        return false;
    }
    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            // find the first, second, third, fourth... smallest value
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            // swaps the smallest value with the position 'i'
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
            //next pls
        }
    }
    /**
     * Demonstrates linear searching over an unsorted array
     */
    public static void demoLinearSearchUnsorted() {
        System.out.println("--- Linear Search Timing (unsorted) ---");
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] randomNumbers = generateNumbers(i, MAX_VALUE);
            int valueFound = 0;
            long start = System.currentTimeMillis();
            for (int j = 0; j <= i; j++) {
                int ranNum = (int)(Math.random() * MAX_VALUE);
                boolean ans = linearSearch(randomNumbers, ranNum);
                if (ans == true) {
                    valueFound = valueFound + 1;
                }
            }
            long end = System.currentTimeMillis();
            System.out.printf("Number of items       : %s\n", i);
            System.out.printf("Times value was found : %s\n", valueFound);
            System.out.printf("Total search time     : %d ms\n", end - start);
            System.out.println();
        }
    }
    /**
     * Demonstrates linear searching over a sorted array
     */
    public static void demoLinearSearchSorted() {
        System.out.println("--- Linear Search Timing (Selection Sort) ---");
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] randomNumbers = generateNumbers(i, MAX_VALUE);
            int timesFound = 0;
            long start = System.currentTimeMillis();
            selectionSort(randomNumbers);
            for (int j = 0; j <= i; j++) {
                int ranNum = (int)(Math.random() * MAX_VALUE);
                boolean ans = linearSearch(randomNumbers, ranNum);
                if (ans == true) {
                    timesFound += 1;
                }
            }
            long end = System.currentTimeMillis();
            System.out.printf("Number of items       : %s\n", i);
            System.out.printf("Times value was found : %s\n", timesFound);
            System.out.printf("Total search time     : %d ms\n", end - start);
            System.out.println();
        }

    }
    /**
     * Demonstrates binary searching when using a Selection Sort
     */
    public static void demoBinarySearchSelectionSort() {
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] randomNumbers = generateNumbers(i, MAX_VALUE);
            int timesFound = 0;
            long start = System.currentTimeMillis();
            selectionSort(randomNumbers);
            for (int j = 0; j <= i; j++) {
                int ranNum = (int)(Math.random() * MAX_VALUE);
                // System.out.println("work");
                boolean ans = binarySearch(randomNumbers, ranNum);
                if (ans == true) {
                    timesFound += 1;
                }
            }
            long end = System.currentTimeMillis();
            System.out.printf("Number of items       : %s\n", i);
            System.out.printf("Times value was found : %s\n", timesFound);
            System.out.printf("Total search time     : %d ms\n", end - start);
            System.out.println();
        }
    }
    /**
     * Demonstrates binary searching when using the build in Arrays.sort
     */
    public static void demoBinarySearchFastSort() {
        System.out.println("--- Binary Search Timing (Arrays.sort) ---");
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] randomNumbers = generateNumbers(i, MAX_VALUE);
            int timesFound = 0;
            long start = System.currentTimeMillis();
            Arrays.sort(randomNumbers);
            for (int j = 0; j <= i; j++) {
                int ranNum = (int)(Math.random() * MAX_VALUE);
                boolean ans = binarySearch(randomNumbers, ranNum);
                if (ans == true) {
                    timesFound += 1;
                }
            }
            long end = System.currentTimeMillis();
            System.out.printf("Number of items       : %s\n", i);
            System.out.printf("Times value was found : %s\n", timesFound);
            System.out.printf("Total search time     : %d ms\n", end - start);
            System.out.println();
        }
    }
}