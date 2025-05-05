package sortMethods;

/**
 * InsertionSort class implements the insertion sort algorithm for sorting an array of comparable elements.
 * It extends the AbsTimer class to measure the time taken for sorting.
 *
 * @param <T> the type of elements in the array, which must be comparable
 * @see AbsTimer
 * @see SortMethod
 */
public class InsertionSort<T extends Comparable<T>> extends AbsTimer implements SortMethod<T> {

    /**
     * Sorts the given array using the insertion sort algorithm.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public T[] sort (T[] array) {
        //start the timer
        stratTimer();

        // Traverse through 1 to array.length
        // The first element is already sorted, so we start from the second element
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

        //stop the timer
        stopTimer();
        return array;
    }
}