public class CatalansNumber {
    public static int catalan(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalan(i) * catalan(n - i - 1);
        }
        return ans;
    }

    public static int catalan(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalan(i, dp) * catalan(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    public static int catalan2(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(catalan(n));
        int dp[] = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println(catalan(n, dp));
        System.out.println(catalan2(n));
    }
}
