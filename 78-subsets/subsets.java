class Solution {
    public List<List<Integer>> subsets(int[] nums){
        int subsets = 1 << nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int num = 0; num < subsets; num++){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if((num & (1 << i)) != 0) list.add(nums[i]);
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result list
        result.add(new ArrayList<>(current));

        // Iterate through the remaining elements starting from 'index'
        for (int i = index; i < nums.length; i++) {
            // Include the current element in the subset
            current.add(nums[i]);
            // Recursively generate subsets from the next index
            generateSubsets(i + 1, nums, current, result);
            // Backtrack: remove the current element before the next iteration
            current.remove(current.size() - 1);
        }
    }
}