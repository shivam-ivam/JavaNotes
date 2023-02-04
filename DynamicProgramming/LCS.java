import java.util.*;

// A subsequene of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
public class LCS {
    public static int longestCommonSubsequence(String str1, String str2, int idx1, int idx2) {
        if (idx1 >= str1.length() || idx2 >= str2.length()) {
            return 0;
        }

        if (str1.charAt(idx1) == str2.charAt(idx2)) {
            return longestCommonSubsequence(str1, str2, idx1 + 1, idx2 + 1) + 1;
        } else {
            int ans1 = longestCommonSubsequence(str1, str2, idx1 + 1, idx2);
            int ans2 = longestCommonSubsequence(str1, str2, idx1, idx2 + 1);
            return Math.max(ans1, ans2);
        }
    }

    public static int longestCommonSubsequence2(String str1, String str2, int idx1, int idx2, int dp[][]) {
        if (idx1 >= str1.length() || idx2 >= str2.length()) {
            return 0;
        }
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        if (str1.charAt(idx1) == str2.charAt(idx2)) {
            return dp[idx1][idx2] = longestCommonSubsequence(str1, str2, idx1 + 1, idx2 + 1) + 1;
        } else {
            int ans1 = longestCommonSubsequence(str1, str2, idx1 + 1, idx2);
            int ans2 = longestCommonSubsequence(str1, str2, idx1, idx2 + 1);
            return dp[idx1][idx2] = Math.max(ans1, ans2);
        }
    }

    public static int lcs3(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    // longest common substring
    // a substring is a contiquous sequence of characters within a string
    public static int longestCommonSubstring(String str1, String str2, int idx1, int idx2, int count, int prevCount) {
        if (idx1 >= str1.length() || idx2 >= str2.length()) {
            prevCount = Math.max(count, prevCount);
            return prevCount;
        }

        if (str1.charAt(idx1) == str2.charAt(idx2)) {
            return longestCommonSubstring(str1, str2, idx1 + 1, idx2 + 1, count + 1, prevCount);
        } else {
            prevCount = Math.max(count, prevCount);
            count = 0;
            int ans1 = longestCommonSubstring(str1, str2, idx1 + 1, idx2, count, prevCount);
            int ans2 = longestCommonSubstring(str1, str2, idx1, idx2 + 1, count, prevCount);
            return Math.max(ans2, ans1);
        }

    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aebcfdef";
        System.out.println("method 1(recursion) : " + longestCommonSubsequence(str1, str2, 0, 0));
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("method 2 (memoization) : " + longestCommonSubsequence2(str1, str2, 0, 0, dp));
        System.out.println("method 3 (tabulation) : " + lcs3(str1, str2));
        System.out.println(longestCommonSubstring(str1, str2, 0, 0, 0, 0));
    }
}
