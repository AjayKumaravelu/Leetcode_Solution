class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flipCount = 0; // Total number of flips
        int[] isFlipped = new int[n]; // Array to track flips at each position
        int currentFlips = 0; // Current number of flips affecting the current position

        for (int i = 0; i < n; i++) {
            // If out of range, reduce currentFlips by the value at isFlipped[i - k]
            if (i >= k) {
                currentFlips ^= isFlipped[i - k];
            }

            // If current position needs to be flipped
            if (nums[i] == currentFlips % 2) {
                // If flipping is not possible due to insufficient length, return -1
                if (i + k > n) {
                    return -1;
                }
                // Flip the current position
                flipCount++;
                currentFlips ^= 1;
                isFlipped[i] = 1; // Mark that we flipped at this position
            }
        }

        return flipCount;
    }
}