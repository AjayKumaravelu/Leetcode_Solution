class Solution {
    public int removeDuplicates(int[] nums) {
        // Using two pointer approach
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            // We will check whether the element which is same or not
            if(nums[j] != nums[i]){
                nums[i+1] = nums[j];
                i++;
            }
        }

        return i+1;

    }

}