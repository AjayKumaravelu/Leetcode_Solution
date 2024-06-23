class Solution {
    public void perm(int index, int[] nums, List<List<Integer>> ans){
        if(index == nums.length){
            // copy ds to ans;
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                ds.add(nums[i]);
            }

            ans.add(new ArrayList<>(ds));
            return;
        }

        // We will traverse from index to n - 1
        for(int i = index; i < nums.length; i++){
            swap(i, index, nums);
            perm(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        perm(0,nums,ans);
        return ans;    
    }
}
