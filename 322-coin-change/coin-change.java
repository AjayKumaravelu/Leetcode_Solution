class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int T = 0; T <= amount; T++){
            dp[0][T] = (T % coins[0] == 0) ? T / coins[0] : amount + 1;
        }

        for(int i = 1; i < n; i++){
            for(int T = 0; T <= amount; T++){
                int nottake = dp[i-1][T];
                int take = amount + 1;
                if(coins[i] <= T) take = 1 + dp[i][T - coins[i]];
                dp[i][T] = Math.min(take, nottake);
            }
        }

        return dp[n - 1][amount] > amount ? -1 : dp[n - 1][amount];
    }
}