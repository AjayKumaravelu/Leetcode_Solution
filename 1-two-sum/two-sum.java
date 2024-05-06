class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the value and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If yes, return the indices of the two numbers
                return new int[]{map.get(complement), i};
            }
            
            // Put the current element and its index into the map
            map.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array
        return new int[0];
    }
}