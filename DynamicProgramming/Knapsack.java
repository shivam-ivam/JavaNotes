import java.util.*;

class Knapsack {
    public static int knapsack(int val[], int wt[], int W, int idx) {
        if (W <= 0 || idx == val.length) {
            return 0;
        }

        if (W >= wt[idx]) {

            // include
            int ans1 = val[idx] + knapsack(val, wt, W - wt[idx], idx + 1);
            // exclude
            int ans2 = knapsack(val, wt, W, idx + 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, idx + 1);
        }

    }

    public static int knapsack2(int val[], int wt[], int W, int idx, int dp[][]) { // memoization // T.C = O(n*w);
        if (W <= 0 || idx == val.length) {
            return 0;
        }
        if (dp[W][idx] != -1) {
            return dp[idx][idx];
        }
        if (W >= wt[idx]) {

            // include
            int ans1 = val[idx] + knapsack2(val, wt, W - wt[idx], idx + 1, dp);
            // exclude
            int ans2 = knapsack2(val, wt, W, idx + 1, dp);
            return dp[W][idx] = Math.max(ans1, ans2);
        } else {
            return dp[W][idx] = knapsack2(val, wt, W, idx + 1, dp);
        }

    }

    public static int knapsack3(int val[], int wt[], int W) {
        int dp[][] = new int[val.length + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {

                    if (wt[i-1] <= j) {
                        // include
                        int ans1 = val[i-1] + dp[i - 1][j - wt[i-1]];

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
        int ans1 = knapsack(val, wt, W, 0);
        System.out.println("recursion method O(2^n) : " + ans1);

        int dp[][] = new int[W + 1][val.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans2 = knapsack2(val, wt, W, 0, dp);
        System.out.println("memoization method O(n*W) : " + ans2);

        int ans3 = knapsack3(val, wt, W);
        System.out.println("Knapsack method 3 O(n*W) : " + ans3);
    }
}