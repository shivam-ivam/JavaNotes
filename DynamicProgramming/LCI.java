import java.util.*;

public class LCI {
    public static int longestCommonIntegers(int arr[]) {
        // creating a hash set in order to remove the same elements
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        // putting back the elements into a new array
        int arr2[] = new int[set.size()];
        int j = 0;
        for (int e :set) {
            arr2[j++] = e; 
        }
        // sort the array
        Arrays.sort(arr2);

        // now doing the LCS approach
        int dp[][] = new int[arr.length+1][arr2.length+1];
        
        for (int i = 0; i < dp.length; i++) {
            for (int k = 0; k < dp[0].length; k++) {
                if (i == 0 || k == 0) {
                    dp[i][k] = 0;
                } else {
                    if(arr[i-1] == arr2[k-1]){
                        dp[i][k] = dp[i-1][k-1] + 1;
                    }else{
                        dp[i][k] = Math.max(dp[i][k - 1], dp[i - 1][k]);
                    }
                }
            }
        }
        return dp[arr.length][arr2.length];

    }

    public static void main(String[] args) {
        int arr[] = { 50, 40, 10, 20, 70, 30, 60 };
System.out.println(longestCommonIntegers(arr));
    }
}
