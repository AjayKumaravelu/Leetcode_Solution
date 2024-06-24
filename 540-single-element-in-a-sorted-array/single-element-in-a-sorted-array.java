class Solution {
    public int singleNonDuplicate(int[] nums) {
        //we will initialize low to 0 and high to n - 2 because if the last element is unique
        int low = 0;
        int high = nums.length - 2;

        while(low <= high){
            int mid = (low + high)>>1;
            // In left half 1st instance even and 2nd instance odd instead of two if we user xor;
            if(nums[mid] == nums[mid^1]){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return nums[low];
    }
}