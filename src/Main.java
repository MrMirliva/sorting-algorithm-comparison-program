import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import sortMethods.SortMethod;
import sortMethods.HeapSort;
import sortMethods.InsertionSort;
import sortMethods.MergeSort;
import sortMethods.QuickSort;

public class Main {

    // Sorting algorithm options
    private static SortMethodOption sortMethodOption = SortMethodOption.DEFAULT;
    private static DataInputOption dataInputOption = DataInputOption.DEFAULT;
    private static DataOrderOption dataOrderOption = DataOrderOption.DEFAULT;
    private static ArraySizeOption arraySizeOption = ArraySizeOption.DEFAULT;

    // Sorting algorithm instance
    private static SortMethod<Integer> sortMethodInstance;


    public static void main(String[] args) {
        menu();

        run();
    }


    // This method displays the menu and gets user input for sorting method, data order, data input, and array size.
    private static void menu() {
        Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            boolean isValidInput = false;
            System.out.println();
            System.out.println("Welcome to the Sorting Algorithm Comparison Program!");
            System.out.println("Please select an option:");
            System.out.println("1. Test all sorting algorithms");
            System.out.println("2. Test a specific sorting algorithm");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                System.out.println("You selected test all sorting algorithms");
                isValidInput = true;
                return;
            case 2:
                System.out.println("You selected test a specific sorting algorithm");
                isValidInput = true;
                break;
            case 9:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
            }

            if (isValidInput) {
                break;
            }
        }

        while (true) {
            System.out.println();
            boolean isValidInput = false;
            System.out.println("Please select a sorting method:");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Heap Sort");
            System.out.println("4. Quick Sort");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                System.out.println("You selected Insertion Sort");
                sortMethodOption = SortMethodOption.INSERTION_SORT;
                isValidInput = true;
                break;
            case 2:
                System.out.println("You selected Merge Sort");
                sortMethodOption = SortMethodOption.MERGE_SORT;
                isValidInput = true;
                break;
            case 3:
                System.out.println("You selected Heap Sort");
                sortMethodOption = SortMethodOption.HEAP_SORT;
                isValidInput = true;
                break;
            case 4:
                System.out.println("You selected Quick Sort");
                sortMethodOption = SortMethodOption.QUICK_SORT;
                isValidInput = true;
                break;
            case 9:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
            }

            if (isValidInput) {
                break;
            }
        }


        while (true) {
            System.out.println();
            boolean isValidInput = false;
            System.out.println("Please select a data order option:");
            System.out.println("1. Increasing order");
            System.out.println("2. Decreasing order");
            System.out.println("3. Random order");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                System.out.println("You selected Increasing order");
                dataOrderOption = DataOrderOption.INCREASING;
                isValidInput = true;
                break;
            case 2:
                System.out.println("You selected Decreasing order");
                dataOrderOption = DataOrderOption.DECREASING;
                isValidInput = true;
                break;
            case 3:
                System.out.println("You selected Random order");
                dataOrderOption = DataOrderOption.RANDOM;
                isValidInput = true;
                break;
            case 9:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
            }

            if (isValidInput) {
                break;
            }
        
        }

        if(dataOrderOption == DataOrderOption.RANDOM){ 
            while (true) {
                System.out.println();
                boolean isValidInput = false;
                System.out.println("Please select a data input option:");
                System.out.println("1. Load from file");
                System.out.println("2. Generate random data");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                switch (choice) {
                case 1:
                    System.out.println("You selected Load from file");
                    dataInputOption = DataInputOption.LOAD_FROM_FILE;
                    isValidInput = true;
                    break;
                case 2:
                    System.out.println("You selected Generate random data");
                    dataInputOption = DataInputOption.GENERATE_RANDOM_DATA;
                    isValidInput = true;
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                }

                if (isValidInput) {
                    break;
                }
            
            }
        }
        else {
            dataInputOption = DataInputOption.GENERATE_RANDOM_DATA;
        }

        while (true) {
            System.out.println();
            boolean isValidInput = false;
            System.out.println("Please select an array size option:");
            System.out.println("1. 1K");
            System.out.println("2. 10K");
            System.out.println("3. 100K");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                System.out.println("You selected 1K array size");
                arraySizeOption = ArraySizeOption.SMALL;
                isValidInput = true;
                break;
            case 2:
                System.out.println("You selected 10K array size");
                arraySizeOption = ArraySizeOption.MEDIUM;
                isValidInput = true;
                break;
            case 3:
                System.out.println("You selected 100K array size");
                arraySizeOption = ArraySizeOption.LARGE;
                isValidInput = true;
                break;
            case 9:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
            }

            if (isValidInput) {
                break;
            }
        
        }
    }

    // This method runs the sorting algorithm based on user input.
    private static void run() {

        // Run all sorting algorithms if the user selected "test all sorting algorithms"
        if(sortMethodOption == SortMethodOption.DEFAULT 
        && dataInputOption == DataInputOption.DEFAULT
        && dataOrderOption == DataOrderOption.DEFAULT
        && arraySizeOption == ArraySizeOption.DEFAULT) {
            
            sorter(SortMethodOption.INSERTION_SORT, DataOrderOption.INCREASING, ArraySizeOption.SMALL);
            sorter(SortMethodOption.MERGE_SORT, DataOrderOption.INCREASING, ArraySizeOption.SMALL);
            sorter(SortMethodOption.HEAP_SORT, DataOrderOption.INCREASING, ArraySizeOption.SMALL);
            sorter(SortMethodOption.QUICK_SORT, DataOrderOption.INCREASING, ArraySizeOption.SMALL);

            sorter(SortMethodOption.INSERTION_SORT, DataOrderOption.DECREASING, ArraySizeOption.SMALL);
            sorter(SortMethodOption.MERGE_SORT, DataOrderOption.DECREASING, ArraySizeOption.SMALL);
            sorter(SortMethodOption.HEAP_SORT, DataOrderOption.DECREASING, ArraySizeOption.SMALL);
            sorter(SortMethodOption.QUICK_SORT, DataOrderOption.DECREASING, ArraySizeOption.SMALL);
            
            sorter(SortMethodOption.INSERTION_SORT, DataOrderOption.RANDOM, ArraySizeOption.SMALL);
            sorter(SortMethodOption.MERGE_SORT, DataOrderOption.RANDOM, ArraySizeOption.SMALL);
            sorter(SortMethodOption.HEAP_SORT, DataOrderOption.RANDOM, ArraySizeOption.SMALL);
            sorter(SortMethodOption.QUICK_SORT, DataOrderOption.RANDOM, ArraySizeOption.SMALL);


            sorter(SortMethodOption.INSERTION_SORT, DataOrderOption.INCREASING, ArraySizeOption.MEDIUM);
            sorter(SortMethodOption.MERGE_SORT, DataOrderOption.INCREASING, ArraySizeOption.MEDIUM);
            sorter(SortMethodOption.HEAP_SORT, DataOrderOption.INCREASING, ArraySizeOption.MEDIUM);
            sorter(SortMethodOption.QUICK_SORT, DataOrderOption.INCREASING, ArraySizeOption.MEDIUM);

            sorter(SortMethodOption.INSERTION_SORT, DataOrderOption.DECREASING, ArraySizeOption.MEDIUM);
            sorter(SortMethodOption.MERGE_SORT, DataOrderOption.DECREASING, ArraySizeOption.MEDIUM);
            sorter(SortMethodOption.HEAP_SORT, DataOrderOption.DECREASING, ArraySizeOption.MEDIUM);
            sorter(SortMethodOption.QUICK_SORT, DataOrderOption.DECREASING, ArraySizeOption.MEDIUM);

            sorter(SortMethodOption.INSERTION_SORT, DataOrderOption.RANDOM, ArraySizeOption.MEDIUM);
            sorter(SortMethodOption.MERGE_SORT, DataOrderOption.RANDOM, ArraySizeOption.MEDIUM);
            sorter(SortMethodOption.HEAP_SORT, DataOrderOption.RANDOM, ArraySizeOption.MEDIUM);
            sorter(SortMethodOption.QUICK_SORT, DataOrderOption.RANDOM, ArraySizeOption.MEDIUM);


            sorter(SortMethodOption.INSERTION_SORT, DataOrderOption.INCREASING, ArraySizeOption.LARGE);
            sorter(SortMethodOption.MERGE_SORT, DataOrderOption.INCREASING, ArraySizeOption.LARGE);
            sorter(SortMethodOption.HEAP_SORT, DataOrderOption.INCREASING, ArraySizeOption.LARGE);
            sorter(SortMethodOption.QUICK_SORT, DataOrderOption.INCREASING, ArraySizeOption.LARGE);

            sorter(SortMethodOption.INSERTION_SORT, DataOrderOption.DECREASING, ArraySizeOption.LARGE);
            sorter(SortMethodOption.MERGE_SORT, DataOrderOption.DECREASING, ArraySizeOption.LARGE);
            sorter(SortMethodOption.HEAP_SORT, DataOrderOption.DECREASING, ArraySizeOption.LARGE);
            sorter(SortMethodOption.QUICK_SORT, DataOrderOption.DECREASING, ArraySizeOption.LARGE);

            sorter(SortMethodOption.INSERTION_SORT, DataOrderOption.RANDOM, ArraySizeOption.LARGE);
            sorter(SortMethodOption.MERGE_SORT, DataOrderOption.RANDOM, ArraySizeOption.LARGE);
            sorter(SortMethodOption.HEAP_SORT, DataOrderOption.RANDOM, ArraySizeOption.LARGE);
            sorter(SortMethodOption.QUICK_SORT, DataOrderOption.RANDOM, ArraySizeOption.LARGE);

            return;
        }


        // Validate user input
        if(sortMethodOption == SortMethodOption.DEFAULT) {
            throw new IllegalArgumentException("Please select a sorting method.");
        }
        if(dataInputOption == DataInputOption.DEFAULT) {
            throw new IllegalArgumentException("Please select a data input method.");
        }
        if(dataOrderOption == DataOrderOption.DEFAULT) {
            throw new IllegalArgumentException("Please select a data order method.");
        }
        if(arraySizeOption == ArraySizeOption.DEFAULT) {
            throw new IllegalArgumentException("Please select an array size method.");
        }

        // Generate data file if the user selected "Generate random data"
        if(dataInputOption == DataInputOption.GENERATE_RANDOM_DATA) {
            generateFile(arraySizeOption);
        }

        // Test the sorting algorithm with the selected options
        sorter(sortMethodOption, dataOrderOption, arraySizeOption);
    }

    // This method sorts the array using the selected sorting method and data order.
    private static void sorter(SortMethodOption sortMethodOption, DataOrderOption dataOrderOption, ArraySizeOption arraySizeOption) {
        int [] array = null;

        // Create the sorting method instance based on the selected sorting method (sortMethodOption)
        if(sortMethodOption == SortMethodOption.INSERTION_SORT) {
            sortMethodInstance = new InsertionSort<>();
        } else if(sortMethodOption == SortMethodOption.MERGE_SORT) {
            sortMethodInstance = new MergeSort<>();
        } else if(sortMethodOption == SortMethodOption.HEAP_SORT) {
            sortMethodInstance = new HeapSort<>();
        } else if(sortMethodOption == SortMethodOption.QUICK_SORT) {
            sortMethodInstance = new QuickSort<>();
        } else {
            throw new IllegalArgumentException("Invalid sorting method option: " + sortMethodOption);
        }
        
        //Load the array from a file or generate random data based on the selected data order option (dataOrderOption) 
        if(dataOrderOption == DataOrderOption.RANDOM) {
            array = loadFile(arraySizeOption);

        } else if(dataOrderOption == DataOrderOption.INCREASING) {
            array = loadFile(arraySizeOption);
            Arrays.sort(array);

        } else if(dataOrderOption == DataOrderOption.DECREASING) {
            array = loadFile(arraySizeOption);
            Arrays.sort(array);

            int size = array.length;

            for(int i = 0; i < size / 2; i++) {
                int temp = array[i];
                array[i] = array[size - i - 1];
                array[size - i - 1] = temp;
            }
            
        } else {
            throw new IllegalArgumentException("Invalid data order option: " + dataOrderOption);
        }
        

        // Convert the int array to Integer array for sorting
        // This is necessary because the sorting methods expect an array of Comparable elements
        Integer[] integerArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            integerArray[i] = array[i];
        }

        //Sort the array using the selected sorting method
        integerArray = sortMethodInstance.sort(integerArray);

        for (int i = 0; i < array.length; i++) {
            array[i] = integerArray[i];
        }

        // Get the run time in milliseconds from the sorting method instance
        long runTimeMillis = sortMethodInstance.getRunTimeMillis();
        // Print the run time
        writeOutput(sortMethodOption, dataOrderOption, arraySizeOption, array, runTimeMillis);
    }

    // This method generates a random array of integers and saves it to a file.
    private static void generateFile(ArraySizeOption arraySizeOption) {
        int size = 0;
        int[] array;

        switch (arraySizeOption) {
            case SMALL:
                size = 1000;
                break;
            case MEDIUM:
                size = 10000;
                break;
            case LARGE:
                size = 100000;
                break;
            default:
                throw new IllegalArgumentException("Invalid array size option: " + arraySizeOption);
        }

        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100000); // Random number between 0 and 1,000,000
        }

        String fileName;
        
        if(size == 1000) {
            fileName = "inputFiles\\1K_random_input.txt";
        } else if(size == 10000) {
            fileName = "inputFiles\\10K_random_input.txt";
        } else if(size == 100000) {
            fileName = "inputFiles\\100K_random_input.txt";
        }
        else {
            throw new IllegalArgumentException("Invalid array size option: " + arraySizeOption);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int num : array) {
                writer.write(num + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Random data generated and saved to " + fileName);
        }
    }

    // This method loads the array from a file based on the selected array size option.
    private static int[] loadFile(ArraySizeOption arraySizeOption) {
        int size = getSize(arraySizeOption);
        String fileName = getFileName(arraySizeOption);

        int[] array = new int[size];
        
        
        try (Scanner scanner = new Scanner(new java.io.File(fileName))) {
            for (int i = 0; i < size; i++) {
                if (scanner.hasNextInt()) {
                    array[i] = scanner.nextInt();
                } else {
                    throw new IllegalArgumentException("Invalid data in file: " + fileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Data loaded from " + fileName);
        }
        return array;
    }

    // This method writes the sorted data to a file based on the selected array size option.
    private static void writeOutput(SortMethodOption sortMethodOption, DataOrderOption dataOrderOption, ArraySizeOption arraySizeOption, int[] array, long runTimeMillis) {

        String fileName = "outputFiles\\";

        if(sortMethodOption == SortMethodOption.INSERTION_SORT) {
            fileName += "insertionsort_";
        } else if(sortMethodOption == SortMethodOption.MERGE_SORT) {
            fileName += "mergesort_";
        } else if(sortMethodOption == SortMethodOption.HEAP_SORT) {
            fileName += "heapsort_";
        } else if(sortMethodOption == SortMethodOption.QUICK_SORT) {
            fileName += "quicksort_";
        } else {
            throw new IllegalArgumentException("Invalid sorting method option: " + sortMethodOption);
        }

        if(arraySizeOption == ArraySizeOption.SMALL) {
            fileName += "1K_";
        } else if(arraySizeOption == ArraySizeOption.MEDIUM) {
            fileName += "10K_";
        } else if(arraySizeOption == ArraySizeOption.LARGE) {
            fileName += "100K_";
        } else {
            throw new IllegalArgumentException("Invalid array size option: " + arraySizeOption);
        }

        if(dataOrderOption == DataOrderOption.INCREASING) {
            fileName += "increasing_";
        } else if(dataOrderOption == DataOrderOption.DECREASING) {
            fileName += "decreasing_";
        } else if(dataOrderOption == DataOrderOption.RANDOM) {
            fileName += "random_";
        } else {
            throw new IllegalArgumentException("Invalid data order option: " + dataOrderOption);
        }

        fileName += "output.txt";


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("Sorting method: " + sortMethodOption + "\n");
            writer.write("Data order: " + dataOrderOption + "\n");
            writer.write("Array size: " + arraySizeOption + "\n");
            writer.write("Run time (ms): " + runTimeMillis + "\n");
            writer.write("\n");
            writer.write("Sorted data:\n");

            for (int num : array) {
                writer.write(num + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Sorted data saved to " + fileName);
        }
    }

    // This method returns the file name based on the selected array size option.
    private static String getFileName(ArraySizeOption arraySizeOption) {
        String fileName = null;

        if(arraySizeOption == ArraySizeOption.SMALL) {
            fileName = "inputFiles\\1K_random_input.txt";
        } else if(arraySizeOption == ArraySizeOption.MEDIUM) {
            fileName = "inputFiles\\10K_random_input.txt";
        } else if(arraySizeOption == ArraySizeOption.LARGE) {
            fileName = "inputFiles\\100K_random_input.txt";
        }
        else {
            throw new IllegalArgumentException("Invalid array size option: " + arraySizeOption);
        }

        return fileName;
    }

    private static int getSize(ArraySizeOption arraySizeOption) {
        int size = 0;
        if(arraySizeOption == ArraySizeOption.SMALL) {
            size = 1000;
        } else if(arraySizeOption == ArraySizeOption.MEDIUM) {
            size = 10000;
        } else if(arraySizeOption == ArraySizeOption.LARGE) {
            size = 100000;
        }
        else {
            throw new IllegalArgumentException("Invalid array size option: " + arraySizeOption);
        }
        return size;
    }


    //START OF ENUMS
    // This method returns the sorting method option based on the selected sorting method.
    private enum SortMethodOption{ 
        DEFAULT,
        INSERTION_SORT,
        MERGE_SORT,
        HEAP_SORT,
        QUICK_SORT
    }

    // This method returns the data order option based on the selected data order.
    private enum DataOrderOption{
        DEFAULT,
        INCREASING,
        DECREASING,
        RANDOM
    }

    // This method returns the data input option based on the selected data input method.
    private enum DataInputOption{
        DEFAULT,
        LOAD_FROM_FILE,
        GENERATE_RANDOM_DATA,
    }

    // This method returns the array size option based on the selected array size.
    private enum ArraySizeOption {
        DEFAULT,
        SMALL,
        MEDIUM,
        LARGE
    }
    //END OF ENUMS

}
