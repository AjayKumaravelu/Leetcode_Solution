class Solution {
    public int maxSubArray(int[] nums) {
        // Using Kadanes Algorithm;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        // int ansStart = -1;
        // int ansEnd = -1;
        // int start = 0;
        
        for(int i = 0; i < nums.length; i++){
            // for finding the start and end index
            // if(sum == 0){
            //     start = i;
            // }
            sum += nums[i];
            if(sum > max){
                max = sum;
                // ansStart = start;
                // ansEnd = i;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}