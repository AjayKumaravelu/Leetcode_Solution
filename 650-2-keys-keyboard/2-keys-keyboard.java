class Solution {
    public int minSteps(int n) {
        // Array to store the minimum steps required to get i 'A's
        int[] dp = new int[n + 1];

        // Start with dp[1] = 0 because we already have 1 'A'
        for (int i = 2; i <= n; i++) {
            dp[i] = i; // Maximum operations is i (by pasting one by one)
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    // If j is a divisor of i, then we can reach i by
                    // getting to j and then pasting (i / j) times
                    dp[i] = Math.min(dp[i], dp[j] + (i / j));
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }
}