import java.util.Arrays;
import java.util.Collections;

public class SortingAlgorithm {
    public static void bubbleSort(int numbers[]) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

    }

    public static void selectionSort(int numbers[]) {
        int minIndex;
        for (int j = 0; j < numbers.length - 1; j++) {
            minIndex = j;
            for (int i = j + 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[minIndex]) {
                    minIndex = i;
                }
            }
            int temp = numbers[j];
            numbers[j] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
    }

    public static void insertionSort(int numbers[]) {
        for (int i = 1; i < numbers.length; i++) {
            int curr = numbers[i];
            int prev = i - 1;
            while (prev >= 0 && numbers[prev] > curr) {
                numbers[prev + 1] = numbers[prev];
                prev--;
            }
            numbers[prev + 1] = curr;
        }
    }

    public static void countingSort(int numbers[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            largest = Math.max(largest, numbers[i]);
        }
        int count[] = new int[largest + 1];
        for (int i = 0; i < numbers.length; i++) {
            count[numbers[i]]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                numbers[j] = i;
                j++;
                count[i]--;
            }
        }
    }


    public static void bubbleSortDesc(int numbers[]) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSortDesc(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            int max = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[max] < numbers[j]) {
                    max = j;
                }
            }
            int temp = numbers[max];
            numbers[max] = numbers[i];
            numbers[i] = temp;
        }
    }

    public static void insertionSortDesc(int numbers[]) {
        for (int i = 1; i < numbers.length; i++) {

            int currentCard = numbers[i];

            int index = i;
            for (int j = i - 1; j >= 0; j--) {

                if (currentCard > numbers[j]) {
                    numbers[j + 1] = numbers[j];

                } else {

                    index = ++j;
                    break;
                }
                index = j;
            }

            numbers[index] = currentCard;

        }
    }

    public static void printarr(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void main(String args[]) {
        // int numbers[] = { 5, 4, 1, 3, 2 }; // primitive type datatype That is why we
        // can't use it with
        // // collections.reverseorder(). this only accepts objects means non-primitve
        // // datatype
        // Integer arr[] = { 5, 4, 1, 3, 2 };
        // // bubbleSort(numbers);
        // // selectionSort(numbers);
        // // insertionSort(numbers);
        // // Arrays.sort(numbers);
        // Arrays.sort(arr, Collections.reverseOrder());
        // countingSort(numbers);
        // printarr(numbers);

        // home work // decending
        int array[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        // bubbleSortDesc(array);
        // selectionSortDesc(array);
        // insertionSortDesc(array);
        bubbleSort(array);

        printarr(array);

    }
}
