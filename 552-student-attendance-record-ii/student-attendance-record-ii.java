class Solution {
    private static final int MOD = 1000000007;
    public int checkRecord(int n) {
        int[][][] dp = new int[n + 1][2][3];
        
        // Initial state
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    // Add 'P': Resets the count of 'L's to 0
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                    
                    // Add 'A': Increases the count of 'A's by 1
                    if (j > 0) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][k]) % MOD;
                    }
                    
                    // Add 'L': Increases the count of consecutive 'L's by 1
                    if (k < 2) {
                        dp[i][j][k + 1] = (dp[i][j][k + 1] + dp[i - 1][j][k]) % MOD;
                    }
                }
            }
        }

        // Sum up all valid sequences of length n
        int result = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                result = (result + dp[n][j][k]) % MOD;
            }
        }

        return result;
    }
}