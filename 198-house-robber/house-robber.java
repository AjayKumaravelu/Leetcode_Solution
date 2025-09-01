class Solution {
    public int solve(int index, int[] nums,int[] dp){
        // Memoization Approach
        // Base Condition
        // if(index == 0) return nums[index];
        // if(index < 0) return 0;

        // int pick = nums[index] + solve(index-2, nums, dp);
        // int notPick = solve(index-1, nums, dp);
        // return dp[index] = Math.max(pick, notPick);

        // Tabulation Approach
        dp[0] = nums[0];

        for(int i = 1; i < index; i++){
            int pick = nums[i];
            if(i > 1){
                pick += dp[i-2];
            }

            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[index-1];

    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int n = solve(nums.length, nums, dp);
        return n;
    }
}