class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1){
            return 0;
        }
        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return uniquePathMemoization(n-1, m-1, obstacleGrid, dp);
    }

    public int uniquePathRecursion(int i, int j, int[][] arr){
        // Base Condition
        if(i == 0 && j == 0) return 1;

        if(i < 0 || j < 0) return 0;

        if(arr[i][j] == 1) return 0;

        int up = uniquePathRecursion(i - 1, j, arr);
        int left = uniquePathRecursion(i, j -1, arr);

        return up + left;

    }

    public int uniquePathMemoization(int i, int j, int[][] arr, int[][] dp){
        // Top Down approach
        if(i == 0 && j == 0) return 1;
        if(i >= 0 && j >= 0 && arr[i][j] == 1) return 0;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int up = uniquePathMemoization(i - 1, j, arr, dp);
        int left = uniquePathMemoization(i, j - 1, arr, dp);

        return dp[i][j] = up + left;
    } 
}