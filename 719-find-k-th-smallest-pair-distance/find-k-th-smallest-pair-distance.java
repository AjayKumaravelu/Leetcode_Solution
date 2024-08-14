class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);  // Sort the array to make it easier to calculate distances
        int n = nums.length;
        int left = 0;  // Minimum possible distance
        int right = nums[n - 1] - nums[0];  // Maximum possible distance
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countPairs(nums, mid);
            
            if (count < k) {
                left = mid + 1;  // Increase the minimum distance
            } else {
                right = mid;  // Decrease the maximum distance
            }
        }
        
        return left;
    }
    
    // Helper function to count the number of pairs with distance <= mid
    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int j = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= mid) {
                j++;
            }
            count += j - i - 1;
        }
        
        return count;
    }
}