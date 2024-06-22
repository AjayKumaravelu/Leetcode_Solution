class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // This map will store the frequency of the prefix sums.
        Map<Integer, Integer> prefixCount = new HashMap<>();
        // Initialize the prefixCount map with a zero prefix sum.
        prefixCount.put(0, 1);
        
        int count = 0;
        int currentOddCount = 0;
        
        for (int num : nums) {
            // If the current number is odd, increment the currentOddCount.
            if (num % 2 != 0) {
                currentOddCount++;
            }
            
            // If there exists a prefix sum that is `currentOddCount - k`, it means 
            // there are `k` odd numbers between that prefix sum and the current prefix sum.
            if (prefixCount.containsKey(currentOddCount - k)) {
                count += prefixCount.get(currentOddCount - k);
            }
            
            // Add the currentOddCount to the prefixCount map.
            prefixCount.put(currentOddCount, prefixCount.getOrDefault(currentOddCount, 0) + 1);
        }
        
        return count;
    }
}