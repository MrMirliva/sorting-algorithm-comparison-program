package sortMethods;
/**
 * HeapSort class implements the heap sort algorithm for sorting an array of comparable elements.
 * It extends the AbsTimer class to measure the time taken for sorting.
 *
 * @param <T> the type of elements in the array, which must be comparable
 * @see AbsTimer
 * @see SortMethod
 */
public class HeapSort<T extends Comparable<T>> extends AbsTimer implements SortMethod<T> {

    /**
     * Sorts the given array using the heap sort algorithm.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public T[] sort(T[] array) {
        
        //start the timer
        stratTimer();

        int n = array.length;

        // Build heap (rearrange array)
        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract elements from heap
        // The last element is already in place, so we reduce the heap size by 1
        for (int i = n - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }

        //stop the timer
        stopTimer();
        return array;
    }

    /**
     * Recursively heapifies a subtree rooted at index i.
     * This function assumes that the subtrees rooted at left and right are already heapified.
     * 
     * @param array the array to be heapified
     * @param n the size of the heap
     * @param i the index of the root of the subtree
     * @return the heapified array
     */
    private T[] heapify(T[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child exists and is greater than root
        if (left < n && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }

        // Check if right child exists and is greater than largest so far
        if (right < n && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying the affected subtree
        // Swap the largest element with the root
        if (largest != i) {
            T temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }

        return array;
    }
}
