public class UnboundKnapsack {
    public static int knapsack3(int val[], int wt[], int W) {
        int dp[][] = new int[val.length + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {

                    if (wt[i-1] <= j) {
                        // include
                        int ans1 = val[i-1] + dp[i][j - wt[i-1]];

                        // exclude
                        int ans2 = dp[i - 1][j];

                        dp[i][j] = Math.max(ans1, ans2);
                    } else {
                        // exclude
                        dp[i][j] = dp[i - 1][j];
                    }
                }

            }
        }

        return dp[val.length][W];
    }
    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int ans1 = knapsack3(val, wt, W);
        System.out.println(ans1);
 
    }
}
