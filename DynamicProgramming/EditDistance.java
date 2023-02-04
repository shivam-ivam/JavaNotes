import java.util.*;
public class EditDistance {
    public static int editDistance(String word1, String word2, int i1, int i2) {
        if(i1 == 0){
            return i2;
        }
        if(i2 == 0){
            return i1;
        }
        if(word1.charAt(i1) == word2.charAt(i2)){
            return editDistance(word1, word2, i1-1, i2-1);
        }else{
            //add
            int ans1 = editDistance(word1, word2, i1, i2-1) + 1 ;
            // delete
            int ans2 = editDistance(word1, word2, i1 - 1, i2) + 1 ;
            // replace 
            int ans3 = editDistance(word1, word2, i1 - 1, i2 -1) + 1;
            return Math.min(ans1, Math.min(ans2, ans3));
        }
    }
    public static int editDistance2(String str1, String str2) {
        int dp[][] = new int[str1.length()+1][str2.length()+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if( i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else{
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        int add = dp[i][j-1] + 1;
                        int del = dp[i-1][j] + 1;
                        int rep = dp[i-1][j-1] + 1;
                        dp[i][j] = Math.min(add, Math.min(del, rep));
                    }
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "ivam";
System.out.println(editDistance(word1, word2, word1.length()-1, word2.length()-1));
System.out.println(editDistance2(word1, word2));
    }
}
