class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long miss = 1; // The smallest number that we can't form
        int i = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // If the current number in the array is less than or equal to miss,
                // it means we can extend our range of numbers that we can form.
                miss += nums[i];
                i++;
            } else {
                // If the current number in the array is greater than miss,
                // we need to patch the array with miss.
                miss += miss;
                patches++;
            }
        }
        
        return patches;
    }
}