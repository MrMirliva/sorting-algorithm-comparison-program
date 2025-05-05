package sortMethods;

/**
 * QuickSort class implements the quick sort algorithm for sorting an array of comparable elements.
 * It extends the AbsTimer class to measure the time taken for sorting.
 *
 * @param <T> the type of elements in the array, which must be comparable
 * @see AbsTimer
 * @see SortMethod
 */
public class QuickSort<T extends Comparable<T>> extends AbsTimer implements SortMethod<T> {

    /**
     * Sorts the given array using the quick sort algorithm.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public T[] sort(T[] array) {
        // Start the timer
        stratTimer();

        //Run the quick sort algorithm
        quickSort(array, 0, array.length - 1);

        // Stop the timer
        stopTimer();
        return array;
    }

    /**
     * Recursively sorts the array using quick sort.
     *
     * @param array the array to be sorted
     * @param low   the starting index of the array
     * @param high  the ending index of the array
     */
    private void quickSort(T[] array, int low, int high) {
        if (low < high) {
            // Find pivot element such that
            int pivotIndex = partition(array, low, high);

            //Recursively sort elements before and after partition
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array into two halves based on the pivot element.
     * High is chosen as the pivot.
     * 
     * @param array the array to be partitioned
     * @param low   the starting index of the array
     * @param high  the ending index of the array
     * @return      the index of the pivot element after partitioning
     */
    private int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;

        // Traverse through all elements and compare each with the pivot
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the array.
     * @param array the array in which the elements are to be swapped
     * @param i     the index of the first element
     * @param j     the index of the second element
     */
    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
