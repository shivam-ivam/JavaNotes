package backTracking;

public class BTArray {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void bTArr(int arr[], int i) {
        // base case
        if(i >= arr.length){
            printArr(arr);
            return;
        }
        // recursion
        arr[i] = i;
        bTArr(arr, i+1); // function call step
        arr[i] = arr[i] - 2; // backtraking step
    }
    public static void main(String args[]) {
        int arr[] = new int[5];
        bTArr(arr, 0);
        printArr(arr);
    }
}
