import java.nio.channels.Pipe;

public class QuickSort {
    public static void quickSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // kamm
        // int k = si-1;
        // for (int i = 0; i < arr.length-1; i++) {
        // if(arr[i] < arr[pivot]){
        // k++;
        // int temp = arr[k];
        // arr[k] = arr[i];
        // arr[i] = temp;
        // }
        // }
        // k++;
        // int temp = arr[k];
        // arr[k] = arr[pivot];
        // arr[pivot] = temp;
        // quickSort(arr, k-1, si, k-1);
        // quickSort(arr, ei, k + 1, ei);

        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1); // left
        quickSort(arr, pIdx + 1, ei); // right
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i]; // pivot = arr[i]
        arr[i] = temp;
        return i;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 3, 2, 4, 1,3 ,3, 3,33,3,3,3,3,3,3,3,3,3,3,3,3,3,3 };
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);

    }
}
