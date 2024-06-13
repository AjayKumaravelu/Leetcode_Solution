class Solution {
    public void nextPermutation(int[] nums) {
         int n = nums.length;
         // Step 1 :  We are going to find the break point in nums array
         // As the breakpoint can happen at the position minimally on n-2
         int ind = -1;
         for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
         }

         // edge case
         if(ind == -1){
            reverse(nums, 0, n-1);
            return;
         }

         // Step 2 : We are going to find the number which is smallest greater than the breakpoint (ie: ind)
         for(int i = n - 1; i > ind; i--){
            if(nums[i] > nums[ind]){
                swap(nums, i, ind);
                break;
            }
         }

         // Step 3: Sort/reverse the remaining array to make the nnext Permutation minimum
        reverse(nums, ind+1, n-1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }    
}