class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        // Let us iterate through the all height from second to secondlast height
        for(int i = 1; i < n-1; i++){
            // We are finding the maximum height on left, first we are intialising left
            int left = height[i];
            for(int j = 0 ; j < i ; j++){
                left = Math.max(left, height[j]);
            }
            // We are finding the maximum height on right, first we are intialising right
            int right = height[i];
            for(int j = i + 1; j < n; j++){
                right = Math.max(right, height[j]);
            }

            // We are adding the result with the minimum of left and right and subtracting the height of the current bar/index
            res += Math.min(left, right) - height[i];
        }
        return res;
    }
}