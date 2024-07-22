class Solution {
    public int minCost(int n, int[] cuts) {
        // Sort cuts array
        Arrays.sort(cuts);
        int m = cuts.length;
        
        // Create a new cuts array with 0 and n included
        int[] newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[0] = 0;
        newCuts[m + 1] = n;

        // Initialize DP table
        int[][] dp = new int[m + 2][m + 2];

        // Fill the DP table
        for (int length = 2; length <= m + 1; length++) {
            for (int i = 0; i <= m + 1 - length; i++) {
                int j = i + length;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], newCuts[j] - newCuts[i] + dp[i][k] + dp[k][j]);
                }
            }
        }

        return dp[0][m + 1];
    }
}