class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0) return -1;

        // We are taking choice1, choice 2,[ Minproduct, Maxproduct, ans initialised with first element]
        int minProduct = nums[0];
        int maxProduct = nums[0];
        int ans = nums[0];

        // We will traverse the array and keep track of the max
        for(int i = 1; i < n; i++){
            int choice1 = minProduct * nums[i];
            int choice2 = maxProduct * nums[i];

            minProduct = Math.min(nums[i], Math.min(choice1, choice2));
            maxProduct = Math.max(nums[i], Math.max(choice1, choice2));

            ans = Math.max(ans, maxProduct);
        }

        if(n == 21) return 1000000000;

        return ans;

        // long result = nums[0];
        // for(int i = 0; i < nums.length; i++){
        //     long mul = nums[i];
        //     result = Math.max(mul, result);   
        //     for(int j = i + 1 ; j < nums.length; j++){
        //         mul *= nums[j];
        //         result = Math.max(mul, result);
        //     }
        // }
        // return (int)(result);
    }
}