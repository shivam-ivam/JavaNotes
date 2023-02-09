public class MinArrayJumps {
    public static int minArrayJumps(int arr[]) {
        int dp[] = new int[arr.length];
        for (int i = dp.length - 2; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && j+i <arr.length; j++) {


                    int temp = 1 + dp[j + i];
                    ans = Math.min(ans, temp);
                
            }
            dp[i] = ans;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 1, 1, 4 };
        System.out.println(minArrayJumps(arr));
    }
}
