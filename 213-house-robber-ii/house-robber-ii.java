class Solution {
    int currentIndex = 0;
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int maxAmount1 = helper(nums, 0, nums.length - 2);
        int maxAmount2 = helper(nums, 1, nums.length - 1);
        return Math.max(maxAmount1, maxAmount2);
         
    }
    
    public int helper(int[] nums,int start, int end){
        int previous = 0;
        int current = 0;

        for(int i = start ; i <= end ; i++){
            int temp = current;
            current = Math.max(previous + nums[i], current);
            previous = temp;
        }
        return current;
    }
}