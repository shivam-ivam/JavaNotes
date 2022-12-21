public class Recursion{
    public static void printDecOrder(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }else{
            System.out.println(n);
            printDecOrder(n-1);
        }
    }

    public static void printIncOrder(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }
        printIncOrder(n-1);
        System.out.println(n);
    }
    public static int factorial(int n) {
        if(n == 0){
            return 1;
        }
        n = n * factorial(n-1);
        return n;
    }
    public static int naturalNumSum(int n) {
        if(n == 1){
            return 1;
        }
        n = n + naturalNumSum(n-1);
        return n;
    }
    public static int nthFibonacciNum(int n) { // 0 1 1 2 3 5 8 13 21 34 55.......
        if(n==0 || n==1){
            return n;
        }
        int fibn = nthFibonacciNum(n-1) + nthFibonacciNum(n-2);
        return fibn;
    }

    public static boolean isArraySort(int arr[], int i) {
        if(arr.length-1 <= i){
            return true;
        }
        if(arr[i] > arr[i+1]){
return false;
        }
        isArraySort(arr, i+1);
        return true;

    }
    public static int firstOccurence(int arr[], int key, int i) {
        if(arr.length-1 < i){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        int index = firstOccurence(arr, key, i+1);
        return index;
    }
    public static int lastOccurence(int arr[], int key, int i) {

        if(arr.length-1 < i){
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }
    public static int power(int x, int n) {
        if(n == 0)return 1;
        return x * power(x, n-1);
    }
    public static int optimizedPowerCode(int x, int n) {
        if(n==0){
            return 1;
        }
        int halfPow = optimizedPowerCode(x, n/2);
        if(n%2 != 0){
            x = x * halfPow * halfPow;
        }else{
            x = halfPow * halfPow;
        }

        return x;
    }

    public static int tiling(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int fnm1 = tiling(n-1);
        int fnm2 = tiling(n);
        int totWays = fnm1 + fnm2;
        return totWays;
    }
     
    public static void main(String args[]) {
        int n =10;
        int arr[] = {2,4,5,6,7,9,2,4,3};
        // printDecOrder(n);
        // printIncOrder(n);
        // int fact = factorial(5);
        // System.out.println(fact);
        // int sum = naturalNumSum(5);
        // System.out.println(sum);
        // System.out.println(nthFibonacciNum(25));
    //    System.out.println(isArraySort(arr, 0));
    // System.out.println(lastOccurence(arr, 4, 0));
    System.out.println(optimizedPowerCode(2, 5));
    }
}


