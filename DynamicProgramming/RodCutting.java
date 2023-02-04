import java.util.*;

// given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting  up the rod and selling the pieces
public class RodCutting {
    public static int rodCutting(int lenght[], int prices[], int rodLength) {
        int dp[][] = new int[rodLength + 1][prices.length + 1];
        for (int i = 0; i < dp.length; i++) { // i is rod length
            for (int j = 0; j < dp[0].length; j++) { // j is prices and length idx
                if (j == 0 || i == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i >= lenght[j - 1]) {
                        // include
                        int ans1 = prices[j - 1] + dp[i - lenght[j - 1]][j];
                        // exclude
                        int ans2 = dp[i][j - 1];
                        dp[i][j] = Math.max(ans1, ans2);
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[rodLength][prices.length];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;
        System.out.println(rodCutting(length, prices, rodLength));
    }
}
