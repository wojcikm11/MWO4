package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DataReader {

    private static final double MAX = 999999999999999999999999999999999999999.0;
    private static final double MIN = -MAX;

    public static double[] readData(String filePath) throws IllegalArgumentException, FileNotFoundException {
        String strValue = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
        return dataToArray(strValue);
    }

    static double[] dataToArray(String data) {
        data = data.replaceAll("[\nt]", " ").replaceAll("\\s+", " ");
        String[] stringVals = data.trim().split(" ");
        double[] outArray = new double[stringVals.length];
        for (int i = 0; i < stringVals.length; i++) {
            try {
                double doubleVal = Double.parseDouble(stringVals[i]);
                if (doubleVal >= MAX || doubleVal <= MIN)
                    throw new IllegalArgumentException("Wrong size of double value");
                outArray[i] = doubleVal;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Wrong value format");
            }
        }

        return outArray;
    }

}
