// minimum partition
// we have to make two different set from the given array in such a way that the difference of the total of the elements sum in each set is minimum. And we have to return that minimum difference value
public class MinPartition {
    public static int minPartition(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int s1 = sum/2;
        int dp[][] = new int[arr.length+1][s1+1];
        for (int i = 1; i < dp.length; i++) { // i is items
            for (int j = 1; j < dp[0].length; j++) { // j is weight
                if(arr[i-1] <= j){
                    // include
                    int ans1 = arr[i-1] + dp[i-1][j-arr[i-1]];
                    // exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{
                    // exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[arr.length][s1];
        return Math.abs(sum1 - (sum - sum1));
    }
    
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        int min = minPartition(arr);
        System.out.println(min);
    }
}
