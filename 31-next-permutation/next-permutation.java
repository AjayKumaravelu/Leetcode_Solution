class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        // Step 1: Find the largest index k such that nums[k] < nums[k + 1]
        int k = n - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        
        // Step 2: Find the largest index l greater than k such that nums[k] < nums[l]
        if (k >= 0) {
            int l = n - 1;
            while (l > k && nums[l] <= nums[k]) {
                l--;
            }
            // Step 3: Swap the value of nums[k] with that of nums[l]
            swap(nums, k, l);
        }
        
        // Step 4: Reverse the sequence from nums[k + 1] up to and including the final element nums[n]
        reverse(nums, k + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}