class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // Step 1: Create a list to store all subarray sums
        ArrayList<Integer> subarraySums = new ArrayList<>();
        
        // Step 2: Calculate all subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }
        
        // Step 3: Sort the subarray sums
        Collections.sort(subarraySums);
        
        // Step 4: Calculate the sum from index left to right (1-based indexing)
        long result = 0;
        int MOD = 1000000007;
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % MOD;
        }
        
        return (int) result;
    }
}