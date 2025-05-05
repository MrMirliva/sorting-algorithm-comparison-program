package sortMethods;

/**
 * MergeSort class implements the merge sort algorithm for sorting an array of comparable elements.
 * It extends the AbsTimer class to measure the time taken for sorting.
 *
 * @param <T> the type of elements in the array, which must be comparable
 * @see AbsTimer
 * @see SortMethod
 */
public class MergeSort<T extends Comparable<T>> extends AbsTimer implements SortMethod<T> {

    /**
     * Sorts the given array using the merge sort algorithm.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public T[] sort(T[] array) {
        // Start the timer
        stratTimer();

        // Check if the array is null or empty
        if (array == null || array.length == 0) {
            return array;
        }

        //Run the merge sort algorithm
        megreSort(array, 0, array.length - 1);

        // Stop the timer
        stopTimer();
        return array;
    }

    /**
     * Recursively sorts the array using merge sort.
     *
     * @param array the array to be sorted
     * @param left  the starting index of the array
     * @param right the ending index of the array
     * @return the sorted array
     */
    private T[] megreSort(T[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            array = megreSort(array, left, mid);
            array = megreSort(array, mid + 1, right);

            // Merge the sorted halves
            array = merge(array, left, mid, right);
        }

        return array;
    }

    /**
     * Merges two subarrays of the given array.
     * First subarray is array[left..mid] and second subarray is array[mid+1..right].
     *
     * @param array the array to be merged
     * @param left  the starting index of the first subarray
     * @param mid   the ending index of the first subarray
     * @param right the ending index of the second subarray
     * @return the merged array
     */
    private T[] merge(T[] array, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        @SuppressWarnings("unchecked")
        T[] L = (T[]) new Comparable[n1];
        @SuppressWarnings("unchecked")
        T[] R = (T[]) new Comparable[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[mid + 1 + j];
        }

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

        return array;
    }
}
