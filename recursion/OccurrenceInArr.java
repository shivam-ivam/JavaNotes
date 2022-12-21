public class OccurrenceInArr {
    public static void printOccurrenceIndices(int arr[],int i, int key) {
        if(i >= arr.length){
            return;
        }
        if (arr[i] == key) {
            System.out.print(i+" ");
        }
        printOccurrenceIndices(arr, i+1, key);
    }

    public static void main(String args[]) {
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        printOccurrenceIndices(arr,0,2);
    }
}
