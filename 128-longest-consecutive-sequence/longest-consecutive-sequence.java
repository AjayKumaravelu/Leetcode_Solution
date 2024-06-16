class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        if(nums.length == 0){
            return 0;
        }
        int longest = 1;
        for(int i = 0; i < nums.length; i++){
            ans.add(nums[i]);
        }

        for(int it: ans){
            // If its a starting Number
            if(!ans.contains(it - 1)){
                int count = 1;
                int x = it;
                while(ans.contains(x+1)){
                    x = x+1;
                    count++;
                }
                longest = Math.max(longest,count);
            }  
        }
        return longest;
    }
}