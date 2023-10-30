import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InsertionSort {
    // Constants for the experiment
    private static final int NO_EXP = 1000000;
    private static final int SIZE = 100;
    private static final int MAX = 100;

    public static void main(String[] args) {
        // Create an array to store the execution times
        long[] executionTimes = new long[NO_EXP];

        // Perform the experiment NO_EXP times
        for (int exp = 0; exp < NO_EXP; exp++) {
            int[] arr = generateRandomArray(SIZE, MAX);
            long startTime = System.nanoTime();
            insertionSort(arr);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            executionTimes[exp] = elapsedTime;
        }

        // Write execution times to a file
        try {
            FileWriter fileWriter = new FileWriter("InsertionSortData.txt");
            for (long time : executionTimes) {
                fileWriter.write(time + "\n");
            }
            fileWriter.close();
            System.out.println("Data exported to data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Insertion Sort algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Generate a random array of integers
    public static int[] generateRandomArray(int size, int max) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max + 1);
        }
        return arr;
    }
}
