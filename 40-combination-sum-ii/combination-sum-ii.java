class Solution {
    public void findCombination(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds){
        // if target == 0 we will add the ds to the answer
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        // then we will iterate from index to n-1 to find out the possibility
        for(int i = index; i < candidates.length; i++){
            // we can choose the first index so we create a condition i > index or i != index and to leave the same element we will continue
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;

            // we will add the element in that index
            ds.add(candidates[i]);
            findCombination(i + 1, candidates, target - candidates[i], ans, ds);
            // in backtrackinng we should remove the top element
            ds.remove(ds.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // First we will declare the ans List
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}