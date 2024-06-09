class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // HashMap to store the frequency of remainders
        HashMap<Integer, Integer> remainderFrequency = new HashMap<>();
        // Initial condition: remainder 0 with frequency 1
        remainderFrequency.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            // Update prefix sum
            prefixSum += num;

            // Compute remainder of current prefix sum
            int remainder = prefixSum % k;

            // Ensure the remainder is positive
            if (remainder < 0) {
                remainder += k;
            }

            // If this remainder has been seen before, it means there are subarrays
            // whose sums are divisible by k
            if (remainderFrequency.containsKey(remainder)) {
                count += remainderFrequency.get(remainder);
            }

            // Update the frequency of the current remainder in the map
            remainderFrequency.put(remainder, remainderFrequency.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}