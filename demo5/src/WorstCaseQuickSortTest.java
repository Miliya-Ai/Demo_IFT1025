public class WorstCaseQuickSortTest {
    public static void main(String[] args) {
        int[] worstCaseArray = generateWorstCaseArray(1000); // Vous pouvez ajuster la taille du tableau
        long startTime = System.nanoTime();
        QuickSort.quickSort(worstCaseArray);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Temps d'exécution en nanosecondes : " + duration);
    }

    private static int[] generateWorstCaseArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}
