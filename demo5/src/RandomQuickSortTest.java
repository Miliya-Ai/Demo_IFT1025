import java.util.Random;

public class RandomQuickSortTest {
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(1000); // Vous pouvez ajuster la taille du tableau
        long startTime = System.nanoTime();
        QuickSort.quickSort(randomArray);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Temps d'exécution en nanosecondes : " + duration);
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10); // Vous pouvez ajuster la plage de valeurs aléatoires
        }
        return arr;
    }
}
