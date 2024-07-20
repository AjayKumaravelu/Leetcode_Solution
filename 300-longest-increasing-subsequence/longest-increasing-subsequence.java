class Solution {
    public int LIS(int[] nums, int index, int prev_index,int[][] dp) {
        int n = nums.length;
        if (index == n) {
            return 0;
        }
        if(dp[index][prev_index + 1] != -1){
            return dp[index][prev_index + 1];
        }
        int nottake = 0 + LIS(nums, index + 1, prev_index, dp);
        int take = 0;
        if (prev_index == -1 || nums[index] > nums[prev_index]) {
            take = 1 + LIS(nums, index + 1, index, dp);
        }

        dp[index][prev_index + 1] = Math.max(nottake,take); 
        return dp[index][prev_index + 1];    
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        
        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return LIS(nums, 0, -1, dp);
    }
}


        /*if(index == nums.length){
            return 0;
        }
        if(dp[index][prev_index + 1] != -1){
            return dp[index][prev_index + 1];
        }
        int len =   LIS(index + 1, prev_index, nums, dp);
        if(prev_index == -1 || nums[index] > nums[prev_index]){
            len = Math.max(len, LIS(index+1, index, nums, dp));
        }
        return dp[index][prev_index + 1] = len;

    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return LIS(0,-1,nums,dp);
    }
}*/