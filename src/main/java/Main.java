import input.DataReader;
import sort.QuickSort;
import sort.SortingAlgorithm;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide filepath of a file containing numbers to sort as a first argument.");
            System.exit(0);
        }
        String filepath = args[0];
        double[] numbers = null;

        try {
            numbers = DataReader.readData(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SortingAlgorithm quickSort = new QuickSort();
        double[] sorted = quickSort.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(sorted));
    }

}
