package sort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    private static SortingAlgorithm sortingAlgorithm = new QuickSort();

    @Test
    public void test_should_throwIllegalArgumentException_when_givenArrayIsNull() {
        // given
        double[] numbers = null;

        // when, then
        assertThrows(IllegalArgumentException.class, () -> sortingAlgorithm.sort(numbers));
    }

    @Test
    public void test_shouldNot_modifyGivenArrayAsArgument() {
        // given
        double[] numbers = {3, -2, 4, 9, 12, 5};

        // when
        sortingAlgorithm = new QuickSort();
        sortingAlgorithm.sort(numbers);
        double[] expected = {3, -2, 4, 9, 12, 5};

        // then
        assertArrayEquals(expected, numbers, 0);
    }

    @Test
    public void test_should_sortEmptyArray() {
        // given
        double[] emptyArray = {};

        // when
        double[] actual = sortingAlgorithm.sort(emptyArray);
        double[] expected = {};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sortOnePositiveElementArray() {
        // given
        double[] oneElementArray = {2.5};

        // when
        double[] actual = sortingAlgorithm.sort(oneElementArray);
        double[] expected = {2.5};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sortOneNegativeElementArray() {
        // given
        double[] oneElementArray = {-2};

        // when
        double[] actual = sortingAlgorithm.sort(oneElementArray);
        double[] expected = {-2};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sortMaximumElementArray() {
        // given
        double[] maxValueArray = {Double.MAX_VALUE};

        // when
        double[] actual = sortingAlgorithm.sort(maxValueArray);
        double[] expected = {Double.MAX_VALUE};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sortMinimumElementArray() {
        // given
        double[] minValueArray = {Double.MIN_VALUE};

        // when
        double[] actual = sortingAlgorithm.sort(minValueArray);
        double[] expected = {Double.MIN_VALUE};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sortRandomValues() {
        // given
        int seed = 1102;
        Random random = new Random(seed);

        int n = 25000;
        double[] randomValues = new double[n];

        for (int i = 0; i < n; i++) {
            randomValues[i] = random.nextDouble();
        }

        // when
        double[] actual = sortingAlgorithm.sort(randomValues);

        // then
        for (int i = 0; i < actual.length - 1; i++) {
            assertTrue(actual[i + 1] > actual[i]);
        }
    }

    @Test
    public void test_should_sortEvenSizedArray() {
        // given
        double[] evenArray = {4, -1, 3, 4};

        // when
        double[] actual = sortingAlgorithm.sort(evenArray);
        double[] expected = {-1, 3, 4, 4};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sortOddSizedArray() {
        // given
        double[] oddArray = {2, 0, 3, 2, -5};

        // when
        double[] actual = sortingAlgorithm.sort(oddArray);
        double[] expected = {-5, 0, 2, 2, 3};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sortSameValues() {
        // given
        double[] sameElementArray = {6, 6, 6, 6, 6, 6, 6, 6, 6, 6};

        // when
        double[] actual = sortingAlgorithm.sort(sameElementArray);
        double[] expected = {6, 6, 6, 6, 6, 6, 6, 6, 6, 6};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sort_onlyPositiveValues() {
        // given
        double[] positiveValues = {2, 3.5, 1, 7, 5, 11, 105, 43, 5};

        // when
        double[] actual = sortingAlgorithm.sort(positiveValues);
        double[] expected = {1, 2, 3.5, 5, 5, 7, 11, 43, 105};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sort_onlyNegativeValues() {
        // given
        double[] negativeValues = {-2, -10, -0.1, -4, -11, -6, -4, -101};

        // when
        double[] actual = sortingAlgorithm.sort(negativeValues);
        double[] expected = {-101, -11, -10, -6, -4, -4, -2, -0.1};

        // then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void test_should_sort() {
        // given
        double[] mixedValues = {3, 6.1, 0, -10.9, -23, 3, 4.2, 12.56, 1};

        // when
        double[] sortedVector = sortingAlgorithm.sort(mixedValues);
        double[] expected = {-23, -10.9, 0, 1, 3, 3, 4.2, 6.1, 12.56};

        // then
        assertArrayEquals(expected, sortedVector, 0);
    }

}
