class Solution {
    public int trap(int[] height) {
        // Initialising the left and right pointer
        int left = 0;
        int right = height.length - 1;

        // Initialise leftmax rightmax and res
        int leftmax = 0;
        int rightmax = 0;
        int res = 0;

        while(left <= right){
            // Condition for going left and right 
            // We make sure the element on right have someone greater or equal to left
            if(height[left] <= height[right]){
                if(height[left] >= leftmax){
                    leftmax = height[left];
                }else{
                    res += leftmax - height[left];
                }
                left++;
            }
            else{
                if(height[right] >= rightmax){
                    rightmax = height[right];
                }else{
                    res += rightmax - height[right];
                }
                right--;
            }
        }

        return res;
    }
}