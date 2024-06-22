class Solution {
    public void findSubset(int index,int[] nums, List<Integer> ds,List<List<Integer>> ansList){
        // First we will add the data structure to ansList
        ansList.add(new ArrayList<>(ds));
        // We will go from index to n-1
        for(int i = index; i < nums.length; i++){
            // Condition if duplicate are found when i = index we can take that one, otherwise continue if same
            if(i != index && nums[i] == nums[i-1]) continue;

            // We will add the element to the datastructure
            ds.add(nums[i]);
            // Now we will call recursive function for index+1
            findSubset(i + 1, nums, ds, ansList);
            // at last we have to remove the last element from the ds
            ds.remove(ds.size() - 1);
        }
    } 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubset(0,nums, new ArrayList<>(), ansList);
        return ansList;
    }
}