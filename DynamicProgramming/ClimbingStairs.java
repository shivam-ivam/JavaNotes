package DynamicProgramming;

// given nth stair and find the total ways of reaching the nth stair if one can choice either 1 or 2 steps at a time. 
public class ClimbingStairs {
    public static int climbingStairsRecursion(int n) { // simple recursion method // T.C = (2^n)
        if (n == 1 || n == 2) {
            return n;
        }
        return climbingStairsRecursion(n - 2) + climbingStairsRecursion(n - 1);
    }

    public static int climbingStairsMemoization(int n, int memory[]) { // memoization method// T.C = (n)
        if (n == 1 || n == 2) {
            return n;
        }

        if (memory[n - 1] != 0) {
            return memory[n - 1];
        }
        return memory[n - 1] = climbingStairsMemoization(n - 2, memory) + climbingStairsMemoization(n - 1, memory);
    }

    public static int climbingStairsTabulation(int n) { // tabulation method // T.C = (n)
        int dp[] = new int[n + 1];
        for (int index = 0; index < dp.length; index++) {
            if (index > 2) {
                dp[index] = dp[index - 1] + dp[index - 2];
            } else {
                dp[index] = index;
            }
        }
        return dp[n];
    }
    public static int name() {
        
    }

    public static void main(String[] args) {
        int n = 500;
        System.out.println(climbingStairsRecursion(n));
        int memory[] = new int[n];
        System.out.println(climbingStairsMemoization(n, memory));
        System.out.println(climbingStairsTabulation(n));
    }
}
