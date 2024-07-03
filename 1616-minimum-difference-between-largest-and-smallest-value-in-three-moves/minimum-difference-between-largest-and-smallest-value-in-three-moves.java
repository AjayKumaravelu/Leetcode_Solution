class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        
        // If the array has 4 or fewer elements, we can make all elements the same with at most 3 moves
        if (n <= 4) return 0;
        
        // Sort the array
        Arrays.sort(nums);
        
        // Calculate the minimum difference after removing up to 3 elements from either end
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            result = Math.min(result, nums[n - 4 + i] - nums[i]);
        }
        
        return result;
    }
}