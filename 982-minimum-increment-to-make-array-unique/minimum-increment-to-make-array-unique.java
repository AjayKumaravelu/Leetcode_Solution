class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        int moves = 0;
        for (int i = 1; i < nums.length; i++) { // Step 2: Iterate and adjust
            if (nums[i] <= nums[i - 1]) { // If the current number is not unique
                int increment = nums[i - 1] - nums[i] + 1; // Calculate the needed increment
                nums[i] += increment; // Make the current number unique
                moves += increment; // Count the moves
            }
        }
        return moves; // Return the total number of moves
    }
}