class Solution {
    public int subsetXORSum(int[] nums) {
        return calculateXORSum(nums, 0, 0);
    }

    private int calculateXORSum(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        // Recursively calculate the sum of XOR totals including the current element
        int includeCurrent = calculateXORSum(nums, index + 1, currentXOR ^ nums[index]);
        // Recursively calculate the sum of XOR totals excluding the current element
        int excludeCurrent = calculateXORSum(nums, index + 1, currentXOR);
        // Return the sum of both cases
        return includeCurrent + excludeCurrent;
    }
}