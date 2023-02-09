
public class MCM {
    public static int mcm(int arr[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

    public static int mcm2(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm2(arr, i, k, dp);
            int cost2 = mcm2(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }

    public static int mcm3(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int len = 2; len <= n-1; len++) {
            for (int i = 1; i <=n-len; i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int j2 = i; j2 <= j-1; j2++) {
                    int cost1 = dp[i][j2];
                    int cost2 = dp[j2+1][j];
                    int cost3 = arr[i-1]*arr[j2]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost3+cost1+cost2);
                }
            }
        }
        print(dp);

        return dp[1][n - 1];
    }

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 }; // n = 5
        int n = arr.length;
        // System.out.println(mcm(arr, 1, n - 1));

        // int dp[][] = new int[n][n];
        // for (int i = 0; i < dp.length; i++) {
        // for (int j = 0; j < dp[0].length; j++) {
        // dp[i][j] = -1;
        // }
        // }
        // System.out.println(mcm2(arr, 1, n-1, dp));

        System.out.println(mcm3(arr));
    }
}
