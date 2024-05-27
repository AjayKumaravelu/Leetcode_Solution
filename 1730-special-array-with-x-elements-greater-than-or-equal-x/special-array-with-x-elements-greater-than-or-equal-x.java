class Solution {
    public int specialArray(int[] nums) {
        // Sort the array in descending order
        Arrays.sort(nums);
        
        // Iterate over possible values of x
        for (int x = 1; x <= nums.length; x++) {
            if (nums[nums.length - x] >= x && (x == nums.length || nums[nums.length - x - 1] < x)) {
                return x;
            }
        }
        return -1;
    }
}