class Solution {
    public void findCombination(int index, int[] candidate, int target, List<List<Integer>> ans, List<Integer> ds){
        // if the index == n that means we arrived at the last possibility
        if(index == candidate.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // if the arr[index] <= target then we will take that index or pick up the index
        if(candidate[index] <= target){
            // We will add the index
            ds.add(candidate[index]);
            // Call the recursive function to pick the index
            findCombination(index,candidate, target - candidate[index],ans,ds);
            //As we backtrack we have to remove the element
            ds.remove(ds.size() - 1);
        }

        // Call the recursive function to not pick the index
        findCombination(index + 1,candidate, target ,ans,ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0,candidates,target,ans, new ArrayList<>());
        return ans;
    }
    
}
