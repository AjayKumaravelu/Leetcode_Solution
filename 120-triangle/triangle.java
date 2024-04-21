class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int n = triangle.size();
        int[] dp = new int[n];

        // Initializing the dp array with the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Iterating through the triangle bottom-up, starting from the second last row
        for (int i = n - 2; i >= 0; i--) {
            // Iterating through each element of the current row
            for (int j = 0; j <= i; j++) {
                // Choosing the minimum path sum from the current element to the bottom
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        // The first element of dp will hold the minimum path sum from top to bottom
        return dp[0];
    }
}