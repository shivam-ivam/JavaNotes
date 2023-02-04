public class WildCards {
    public static boolean wildCard(String text, String pattern, int idx1, int idx2) {
        if (idx1 == 0 || idx2 == 0) {
            return true;
        }

        return true;
    }

    public static boolean wildCard2(String text, String pattern) {
        boolean dp[][] = new boolean[text.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = false;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pattern.charAt(j - 1) == '?' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    dp[i][j] = false;

                }

            }
        }
        print(dp);

        return dp[text.length()][pattern.length()];
    }

    public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(" " + dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String text = "baaabab", pattern = "*****ba*****ab";
        // String text = "abc", pattern = "**?b*";
        boolean ans = wildCard2(text, pattern);
        System.out.println(ans);
    }
}
