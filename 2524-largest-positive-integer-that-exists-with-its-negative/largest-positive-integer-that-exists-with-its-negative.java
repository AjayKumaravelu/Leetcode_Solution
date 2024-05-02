class Solution {
    public int findMaxK(int[] nums) {
        int[] arr = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                arr[j++] = nums[i];
            }
        }
        Arrays.sort(arr);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int num : nums) {
                if ((arr[i] * -1) == num) {
                    return num;
                }
            }
        }
        return -1;
    }
}