class Solution {
    public int climbStairs(int n) {
        // Recursion

        // if(n == 0) return 1;
        // if(n == 1) return 1;
        // return climbStairs(n - 2) + climbStairs(n - 1);

        // Memoization --> Bottom Up Approach

        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // if(n == 0) return 1;
        // if(n == 1) return 1;
        // if(dp[n] != -1) return dp[n];
        // return dp[n] = climbStairs(n-2) + climbStairs(n-1);

        // Tabulation --> Top Down Approach
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}