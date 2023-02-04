import java.util.*;

// given an array of coins. and a sum. We have to return the total ways of coin change from the coins array (repition of coin is allowed) such that we can get the sum.
public class CoinChange {

    public static int coinChange(int coins[], int sum, int idx) {
        if (sum == 0) {
            return 1;
        }
        if (idx == coins.length) {
            return 0;
        }
        if (sum >= coins[idx]) {
            // include
            int ways1 = coinChange(coins, sum - coins[idx], idx);
            // exclude
            int ways2 = coinChange(coins, sum, idx + 1);
            return ways1 + ways2;
        } else {
            return coinChange(coins, sum, idx + 1);
        }

    }

    public static int coinChange2(int coins[], int sum) {
        int dp[][] = new int[coins.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else { 
                    if (j >= coins[i - 1]) {
                        // include
                        int ways1 = dp[i][j - coins[i - 1]];
                        // exclude
                        int ways2 = dp[i - 1][j];
                        dp[i][j] = ways1 + ways2;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[coins.length][sum];

    }

    public static void main(String[] args) {
        int coins[] = { 2, 5, 3, 6 };
        int sum = 10;
        System.out.println(coinChange(coins, sum, 0));
        System.out.println(coinChange2(coins, sum));
    }
}
