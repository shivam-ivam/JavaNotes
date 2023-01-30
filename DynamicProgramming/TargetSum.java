public class TargetSum {
    public static boolean targetSum(int arr[], int sum) {
        boolean dp[][] = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int V = arr[i - 1];

                // include
                if (V <= j && dp[i - 1][j - V] == true) {
                    dp[i][j] = true;
                } // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[arr.length][sum];

    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int sum = 10;
        System.out.println(targetSum(arr, sum));
    }
}
