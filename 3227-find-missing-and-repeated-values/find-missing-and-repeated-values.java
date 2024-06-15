class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long N = n * n;
        // SN sum of first n natural numbers
        long SN = (N * (N + 1)) / 2;
        // S2N sum of Square of first n natural numbers
        long S2N = (N * (N + 1) * (2 * N + 1)) / 6;
        long S = 0;
        long S2 = 0;
        // Normal sum of given array s --> normal sum , S2 --> Squared Sum
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                S += grid[i][j];
                S2 += (long)grid[i][j] * (long)grid[i][j];
            }
        }

        // X - Y = val1
        long val1 = S - SN;
        // X^2 - Y^2 = val2
        long val2 = S2 - S2N;
        // X + Y = val2 / val1
        val2 = val2/val1;
        // Solving the above 2 equation --> 2x = val1 + val2 ---> x = val1 + val2 / 2
        long x = (val1 + val2)/2;
        // Substituting the x we will get Y = X - val1
        long y = x - val1;
        int[] ans = {(int)x, (int)y};
        return ans;
    }
}