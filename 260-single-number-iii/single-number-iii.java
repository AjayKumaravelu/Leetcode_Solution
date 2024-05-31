class Solution {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        for (int num : nums) {
            xorAll ^= num;
        }

        // Step 2: Find any set bit in xorAll (rightmost set bit)
        int setBit = xorAll & -xorAll;

        // Step 3: Partition the numbers into two groups and XOR each group
        int x = 0;
        int y = 0;
        for (int num : nums) {
            if ((num & setBit) != 0) {
                x ^= num;  // XOR of first group
            } else {
                y ^= num;  // XOR of second group
            }
        }

        return new int[]{x, y};
    }
}