package sortMethods;

/**
 * SortMethod interface defines the contract for sorting algorithms.
 * It provides methods to sort an array and to get the runtime in milliseconds.
 *
 * @param <T> the type of elements in the array, which must be comparable
 */
public interface SortMethod<T extends Comparable<T>> {
    // Sorts the given array using the sorting algorithm
    public T[] sort(T[] array);

    // Returns the name of the sorting algorithm
    public long getRunTimeMillis();
} 
