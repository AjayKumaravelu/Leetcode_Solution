class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            int more = target - a;
            if(map.containsKey(more)){
                ans[0] = map.get(more);
                ans[1] = i;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}