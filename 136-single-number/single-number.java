class Solution {
    public int singleNumber(int[] nums) {
        // Using XOR method for optimal 
        int n = nums.length;

        int XOR = 0;
        for(int i = 0; i < nums.length; i++){
            XOR = XOR ^ nums[i];
        }
        return XOR;
    }
}