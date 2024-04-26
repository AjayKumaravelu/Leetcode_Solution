class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        
        // Copy the first row from the grid to the dp array
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            // Find the minimum and second minimum values from the previous row
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int min1Index = -1;
            
            for (int j = 0; j < n; j++) {
                if (dp[i-1][j] < min1) {
                    min2 = min1;
                    min1 = dp[i-1][j];
                    min1Index = j;
                } else if (dp[i-1][j] < min2) {
                    min2 = dp[i-1][j];
                }
            }
            
            // Calculate the falling path sum for the current row
            for (int j = 0; j < n; j++) {
                if (j != min1Index) {
                    dp[i][j] = grid[i][j] + min1;
                } else {
                    dp[i][j] = grid[i][j] + min2;
                }
            }
        }
        
        // Find the minimum falling path sum from the last row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n-1][j]);
        }
        
        return minSum;
    }
}