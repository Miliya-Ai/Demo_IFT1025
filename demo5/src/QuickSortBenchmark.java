public class QuickSortBenchmark {

    // diapo 59 et https://www.geeksforgeeks.org/quick-sort/
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    public static void quicksort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quicksort(array, left, pivot - 1);
            quicksort(array, pivot + 1, right);
        }
    }

    public static long benchmark(int[] tab){
        long timeBefor = System.nanoTime();
        quicksort(tab, 0, tab.length - 1);
        long timeAfter = System.nanoTime();
        return timeAfter - timeBefor;
    }

    public static void main(String[] args) {
        for(int i = 1; i < 100; i++){
            int[] tab = randomIntegers(i);
            System.out.println(i + " " + benchmark(tab));
        }
    }

    private static int[] randomIntegers(int i) {
        int[] tab = new int[i];
        for(int j = 0; j < i; j++){
            tab[j] = (int) (Math.random() * 100);
        }
        return tab;
    }
}