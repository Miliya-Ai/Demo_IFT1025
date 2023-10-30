import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SelectionSort {

    // Constants
    private static final int NO_EXP = 1000000;
    private static final int SIZE = 100;
    private static final int MAX = 100;

    public static void main(String[] args) {
        long[] timeResults = new long[NO_EXP];

        // Run the experiment NO_EXP times
        for (int i = 0; i < NO_EXP; i++) {
            int[] arr = generateRandomArray();
            long startTime = System.nanoTime();
            selectionSort(arr);
            long endTime = System.nanoTime();
            timeResults[i] = endTime - startTime;
        }

        // Write results to file
        try {
            FileWriter writer = new FileWriter("SelectionSortData.txt");
            for (long timeResult : timeResults) {
                writer.write(timeResult + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Selection sort algorithm
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to generate random array
    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = random.nextInt(MAX + 1);
        }
        return arr;
    }
}
