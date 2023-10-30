import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BubbleSort {
    // Constants
    private static final int NO_EXP = 1000000;
    private static final int SIZE = 100;
    private static final int MAX = 100;

    public static void main(String[] args) {
        long[] executionTimes = new long[NO_EXP];

        for (int exp = 0; exp < NO_EXP; exp++) {
            int[] randomArray = generateRandomArray(SIZE, MAX);

            long startTime = System.nanoTime();
            bubbleSort(randomArray);
            long endTime = System.nanoTime();

            executionTimes[exp] = endTime - startTime;
        }

        // Export the results to data.txt
        try {
            FileWriter fileWriter = new FileWriter("BubbleSortData.txt");
            for (long time : executionTimes) {
                fileWriter.write(Long.toString(time) + "\n");
            }
            fileWriter.close();
            System.out.println("Results exported to BubbleSortData.txt");
        } catch (IOException e) {
            System.err.println("Error writing to data.txt: " + e.getMessage());
        }
    }

    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // Swap arr[i-1] and arr[i]
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
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
