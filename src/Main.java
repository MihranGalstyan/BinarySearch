import java.util.Arrays;
import java.util.Random;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class Main {
    public static void main(final String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(0, 100);
        }
        int key = 8;

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.printf("(Iterative)Index of %s in array: %s", key, binarySearchIterative(key, array));
        System.out.println();
        System.out.printf("(Recursive)Index of %s in array: %s", key, binarySearchRecursive(key, array));

    }

    public static int binarySearchIterative(int key, int[] array) {
        return binarySearchIterative(key, array, 0, array.length - 1);
    }

    public static int binarySearchIterative(int key, int[] array, int indexFrom, int indexTo) {
        int endIndex = indexTo;
        int startIndex = indexFrom;
        while (startIndex <= endIndex) {
            int mid = (endIndex + startIndex) / 2;
            int midVal = array[mid];

            if (key > midVal) {
                startIndex = mid + 1;
            } else if (key < midVal) {
                endIndex = mid - 1;
            } else return mid;
        }
        return -1;
    }

    public static int binarySearchRecursive(int key, int[] array) {
        return binarySearchRecursive(key, array, 0, array.length - 1);
    }

    public static int binarySearchRecursive(int key, int[] array, int indexFrom, int indexTo) {
        if (indexFrom <= indexTo) {
            int mid = (indexTo + indexFrom) / 2;
            int midVal = array[mid];

            if (key > midVal) {
                return binarySearchRecursive(key, array, mid + 1, indexTo);
            } else if (key < midVal) {
                return binarySearchRecursive(key, array, indexFrom, mid - 1);
            } else return mid;
        } else return -1;
    }
}
