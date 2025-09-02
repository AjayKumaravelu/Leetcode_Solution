class Solution {
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return uniquePathsMemoization(m-1, n-1, dp);
    }
    public int uniquePathsRecursive(int m, int n) {
        // Using recursion
        // Base Condition
        if(m == 0 && n == 0) return 1; // We found the final destination
        if(m < 0 || n < 0) return 0; // We went outside boundary;

        int up = uniquePathsRecursive(m-1, n);
        int left = uniquePathsRecursive(m, n-1);

        return up + left;
        // int N = n + m - 2;
        // int R = m - 1;
        // double result = 1;

        // // finding combination
        // for(int i = 1; i <= R; i++){
        //     result = result * (N -  R + i)/i;
        // }

        // return (int)result;
    }

    public int uniquePathsMemoization(int i, int j, int[][] dp){
        // Base Condition
        if(i == 0 && j == 0) return 1;

        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int up = uniquePathsMemoization(i-1, j , dp);
        int left = uniquePathsMemoization(i, j-1, dp);

        return dp[i][j] = up + left;

    }
}